const quizQuestions = [
  {
    question: "1) Who is the father of C language?",
    options: ["Steve Jobs","James Gosling","Dennis Ritchi","Rasmus Lerdorf"],
    correctAnswer: "Dennis Ritchi"
  },
  {
    question: "2) Which of the following is not a valid C variable name?",
    options: ["int number;", "float number1;", "double _number;", "int $main;"],
    correctAnswer: "int $main;"
  },
  {
    question: "3) All keywords in C are in ____________.",
    options: ["LowerCase letters", "UpperCase letters", "CamelCase letters", "None of the mentioned"],
    correctAnswer: "LowerCase letters"
  },
  {
     question: "4) Which keyword is used to prevent any changes in the variable within a C program?",
     options: ["immutable", "mutable", "const", "volatile"],
    correctAnswer: "const"
  },
  {
     question: "5) What is the result of logical or relational expression in C?",
     options: ["True or False", "0 or 1", "0", "None"],
     correctAnswer: "0 or 1"
  },
  {
    question: "6) What is an example of iteration in C?",
    options: ["for", "while", "do-while", "All of the mentioned"],
    correctAnswer: "All of the mentioned"
  },
  {
    question: "7) The C-preprocessors are specified with _________ symbol.",
    options: ["#", "$", "&", "*"],
    correctAnswer: "#"
  },
  {
     question: "8) Which of the following are C preprocessors?",
     options: ["#ifdef", "#define", "#endif", "All of the mentioned"],
     correctAnswer: "All of the mentioned"
  },
  {
    question: "9) Which of the following return-type cannot be used for a function in C?",
    options: ["char *", "struct", "void", "None of the mentioned"],
    correctAnswer: "None of the mentioned"
   },
   {
     question: "10) What is the sizeof(char) in a 32-bit C compiler?",
     options: ["1 bit", "2 bits", "1 byte", "2 bytes"],
     correctAnswer: "1 byte"
   },
   {
      question: "11) Which of these is NOT a relational or logical operator?",
      options: ["=", "||", "==", "!="],
      correctAnswer: "="
   },
   {
    question: "12) Which one of the following is a loop construct that will always be executed once?",
    options: ["for", "while", "switch", "do while"],
    correctAnswer: "do while"
   },
   {
    question: "13) Directives are translated by the ___________.",
    options: ["Pre-processor", "Compiler", "Linker", "Editor"],
    correctAnswer: "Pre-processor"
   },
   {
    question: "14) while(condition); -justify the given statement?",
    options: [ "Invalid statement", "Valid statement","Syntax error", "None of the mentioned"],
    correctAnswer: "Valid statement"
   },
   {
    question: "15) The binary equivalent of 50 is _____________.",
    options: ["110010","1010110","101","101.011.00.00"],
    correctAnswer: "110010"
   },
   {
	 question: "16) Which function is often used to output values and print text?",
	 options: ["printf()","output()","write()","printword()"],
	 correctAnswer: "printf()"
    },
   {
	 question: "17) Which format specifier is often used to print integers?",
     options: ["%f","%d","%s","%c"],
	 correctAnswer: "%d"
    },
	{
	  question: "18) Which keyword is used to return a value inside a function?",
	  options: ["break","void","get","return"],
	  correctAnswer: "return"
	},
	{
	  question: "19) Which statement can be used to select one of many code blocks to be executed?",
	  options: ["break","when","default","switch"],
	  correctAnswer: "switch"
	},
	{
      question: "20) for(;;) - output for the given code",
      options: ["Infinite loop","1","0","Syntax-error"],
	  correctAnswer: "Infinite loop"
	},		  
];

// Variables to track quiz state
let currentQuestionIndex = 0;
let score = 0;
let timeLeft = 900; // 15 minutes in seconds
let timerInterval;

// Function to start the quiz
function startQuiz() {
  // Hide the start button and display the first question
  document.getElementById("start-button").style.display = "none";
  displayQuestion();
  startTimer();
}

// Function to display a question and its options
function displayQuestion() {
  const currentQuestion = quizQuestions[currentQuestionIndex];
  const questionText = document.getElementById("question-text");
  const answerButtons = document.getElementById("answer-buttons");

  // Clear previous question and answer options
  questionText.innerHTML = "";
  answerButtons.innerHTML = "";

  // Display the current question
  questionText.innerHTML = currentQuestion.question;

  // Create answer buttons for each option
  currentQuestion.options.forEach(option => {
    const button = document.createElement("button");
    button.innerText = option;
    button.classList.add("answer-button");
    answerButtons.appendChild(button);

    // Add click event listener to check the answer
    button.addEventListener("click", function() {
      checkAnswer(option);
    });
  });
}

// Function to check the selected answer
function checkAnswer(selectedOption) {
  const currentQuestion = quizQuestions[currentQuestionIndex];

  // Check if the selected answer is correct
  if (selectedOption === currentQuestion.correctAnswer) {
    score++;
  }

  // Move to the next question or end the quiz if all questions are answered
  currentQuestionIndex++;

  if (currentQuestionIndex < quizQuestions.length) {
    displayQuestion();
  } else {
    endQuiz();
  }
}

// Function to start the timer
function startTimer() {
  timerInterval = setInterval(function() {
    timeLeft--;

    // Calculate minutes and seconds
    const minutes = Math.floor(timeLeft / 60);
    const seconds = timeLeft % 60;

    // Update the timer text
    document.getElementById("minutes").textContent = minutes;
    document.getElementById("seconds").textContent = seconds < 10 ? "0" + seconds : seconds;

    // End the quiz if time runs out
    if (timeLeft <= 0) {
      endQuiz();
    }
  }, 1000);
}

// Function to end the quiz
function endQuiz() {
  // Stop the timer
  clearInterval(timerInterval);

  // Calculate the score percentage
  const wrongAns = quizQuestions.length - score;

  // Display the final score
  const questionContainer = document.getElementById("question-container");
  const resultsWindow = document.getElementById("results-window");

  let message = `
    <h2>Quiz Completed!</h2>
    <p id="question-text">Your Score       : ${score} out of ${quizQuestions.length}</p>
    <p id="question-text">Correct Answers  : ${score}</p>
    
  `;

  // Check score and show modal if score is less than 5
  if (score < 5) {
    message += `<p id="question-text">Better luck next time!</p>`;
  } else {
    message += `<p id="question-text">Congratulations!</p>`;
  }

  resultsWindow.innerHTML = message;
  resultsWindow.classList.remove("hidden");
}

// Function to close the results modal
function closeResultsModal() {
  const resultsWindow = document.getElementById("results-window");
  resultsWindow.classList.add("hidden");
}

// Add event listener to start the quiz when the start button is clicked
document.getElementById("start-button").addEventListener("click", startQuiz);

// Event listener to close modal when clicking outside
window.addEventListener("click", function(event) {
  const resultsWindow = document.getElementById("results-window");
  if (event.target === resultsWindow) {
    closeResultsModal();
  }
});
