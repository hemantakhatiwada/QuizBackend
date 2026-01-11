import { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';
import { Routes, Route, useNavigate } from 'react-router-dom';
import Result from './Result';

function Quiz() {
  const [questions, setQuestions] = useState([]);
  const [started, setStarted] = useState(false);
  const [div1, showdiv1] = useState(true);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [selectedOption, setSelectedOption] = useState(null);


  const navigate = useNavigate();


 useEffect(() => {
  // Fetch questions
  axios.get("http://localhost:8080/get5question")
    .then((res) => setQuestions(res.data))
    .catch(err => console.log(err));

  // Reset score
  axios.post("http://localhost:8080/reset")
    .then(() => console.log("Score reset successfully"))
    .catch(err => console.log("Failed to reset score:", err));
}, []); // run once on mount


  

  const handleNext = () => {
  const question = questions[currentIndex];

  if (!selectedOption) {
    alert("Please select an option!");
    return;
  }

  if (!question || question.id === undefined) {
    alert("Invalid question data!");
    return;
  }

  const questionId = question.id;
  console.log(`Submitting: questionId=${questionId}, selectedOption=${selectedOption}`);

  const query = `?questionId=${encodeURIComponent(questionId)}&selectedOption=${encodeURIComponent(selectedOption)}`;

  axios.post(`http://localhost:8080/submit${query}`)
    .then(response => {
      console.log("Submitted successfully:", response.data);

      if (currentIndex < questions.length - 1) {
        setCurrentIndex(currentIndex + 1);
        setSelectedOption(null);
      } else {
        navigate("/result");
      }
    })
    .catch(error => {
      console.error("Error submitting:", error.response?.data || error.message);
      alert("Failed to submit answer. Please try again.");
    });
};

  return (
    <div style={
      {
         border: "3px solid #1e40af",
    borderRadius: "15px",
    padding: "30px",
    backgroundColor: "#f8fafc",
    boxShadow: "0 8px 20px rgba(0,0,0,0.15)"
      }
    }>
      {/* Start button section */}
      {div1 && (
        <div>
          <h1>Press to Start Quiz!</h1>
          <button
            style={{ fontSize: "40px", backgroundColor: "#fef08a",
            fontWeight: "bold",
    color: "#1e40af", 
   }}
            onClick={() => {
              setStarted(true);
              showdiv1(false);
            }}
          >
            Start Quiz
          </button>
        </div>
      )}

      {/* Question section */}
      {started && questions.length > 0 && (
        <div style={{
          border: "3px solid #000000",
    borderRadius: "15px",
    padding: "30px",
    backgroundColor: "#f8fafc",
    boxShadow: "0 8px 20px rgba(0,0,0,0.15)"
          
        }}
        >
          <p style={
            {
              color:"rgb(255, 51, 51)",
              fontFamily:"sans-serif",
              fontSize:"25px"
            }
          }>{questions[currentIndex].questions}</p>
          <div className="options-container">
  <button className="option-button" onClick={() => setSelectedOption("A")}>
    {questions[currentIndex].optionA}
  </button>
  <button className="option-button" onClick={() => setSelectedOption("B")}>
    {questions[currentIndex].optionB}
  </button>
  <button className="option-button" onClick={() => setSelectedOption("C")}>
    {questions[currentIndex].optionC}
  </button>
  <button className="option-button" onClick={() => setSelectedOption("D")}>
    {questions[currentIndex].optionD}
  </button>
</div>

          <button className="option-button" onClick={handleNext}>
            {currentIndex === questions.length - 1 ? "Submit" : "Next"}
          </button>
        </div>
      )}
    </div>
  );
}

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Quiz />} />
      <Route path="/result" element={<Result />} />
    </Routes>
  );
}

 
