import axios from 'axios';
import { useEffect, useState } from 'react';
import { Routes, Route, useNavigate } from 'react-router-dom';

function Result() {
  const [score, setScore] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    // 1️⃣ Fetch the current score
    axios.get("http://localhost:8080/getscore")
      .then((res) => {
        setScore(res.data);
      })
      .catch(err => console.log(err));

    // 2️⃣ Reset the score immediately after fetching
    
  }, []);

  return (
    <div
    style={
      {backgroundColor:"rgb(204, 216, 255)",
         border: "3px solid #1e40af",
    borderRadius: "15px",
    padding: "30px",
    backgroundColor: "#f8fafc",
    boxShadow: "0 8px 20px rgba(0,0,0,0.15)"
      }
    }>
      <h1>  Your Score is  </h1>
      <p style={
        {
           fontSize: "120px",        // bigger text
    fontWeight: "bold",
    color: "#1e40af",         // better blue
    backgroundColor: "#fef08a", // soft yellow
    padding: "20px 40px",
    borderRadius: "10px",
    boxShadow: "0 10px 25px rgba(0,0,0,0.2)",
    display: "inline-block",
    marginTop: "5px"
        }
      }>{score}</p>
      <br/>
      <button onClick={()=>navigate("/")}
        style={
          {
            fontSize:"25px",
            backgroundColor: "#fef08a",
            fontWeight: "bold",
    color: "#1e40af", 
          }
        }>Play Again</button>
    </div>
  );
}

export default Result;
