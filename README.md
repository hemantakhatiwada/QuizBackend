CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    questions TEXT NOT NULL,
    optionA VARCHAR(255) NOT NULL,
    optionB VARCHAR(255) NOT NULL,
    optionC VARCHAR(255) NOT NULL,
    optionD VARCHAR(255) NOT NULL,
    correctoption VARCHAR(1) NOT NULL
);
CREATE TABLE score (
    id SERIAL PRIMARY KEY,
    score INT NOT NULL
);
