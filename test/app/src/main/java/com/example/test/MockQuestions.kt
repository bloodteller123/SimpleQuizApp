package com.example.test

class MockQuestions {
    private val questions = arrayListOf(
        "What element does the chemical symbol Au stand for?",
        "What is the oldest soft drink in the United States?",
        "In what country do more than half of people believe in elves?",
        "What color dresses do Chinese women traditionally wear on their wedding day?",
        "What sport has been played on the moon?",
        "Where did the croissant originate?",
        "Mount Olympus is the highest mountain in what country?",
        "From which country do French fries originate?",
        "If you are born on the 1st of January, which star sign are you?",
        "Who was George W. Bush’ vice president?",
        "What is the largest continent in size?",
        "How long is the border between the United States and Canada?",
        "When was the first Harry Potter book published?",
        "In The Lion King, who is Simba’s uncle?",
        "Which one of the following companies has a mermaid in its logo?",
        "What is the capital of New Zealand?",
        "What is the national animal of England?",
        "What is the name of the gem in the movie Titanic?",
        "How many players are in a cricket team?",
        "'Onze' is the French number for?")
    private val choices = arrayListOf(
        arrayListOf("Silver", "Salt", "Gold"),
        arrayListOf("Pepsi", "Dr. Pepper", "Coca Cola"),
        arrayListOf("Iceland", "Holland", "Russia"),
        arrayListOf("Black", "Gold", "Red"),
        arrayListOf("Golf", "Football", "Tennis"),
        arrayListOf("Tokyo", "Austria", "France"),
        arrayListOf("Greece", "America", "Canada"),
        arrayListOf("France", "Austria", "Belgium"),
        arrayListOf("Capricorn", "Scorpio", "Libra"),
        arrayListOf("Joe Biden", "Dick Cheney", "Kamala Harris"),
        arrayListOf("Africa", "America", "Asia"),
        arrayListOf("7,525 miles", "6,525 miles", "5,525 miles"),
        arrayListOf("1997", "2002", "2012e"),
        arrayListOf("Timon", "Scar", "James"),
        arrayListOf("Starbucks", "IBM", "Google"),
        arrayListOf("Tokyo", "Wellington", "Ottawa"),
        arrayListOf("Lion", "Rabbit", "Panda"),
        arrayListOf("See you again", "Call of love", "Heart of the Ocean"),
        arrayListOf("7", "5", "11"),
        arrayListOf("5", "11", "3"),
    )
    private val answers = arrayListOf(2, 1,
        0,2,0,1,
        0,2,0,1,
        2,2,0,1,
       0,1,0,2,2,1)


    fun addQuestion(newQuestion: String, newChoices: ArrayList<String>, newAnswer: Int){
        this.questions.add(newQuestion)
        this.choices.add(newChoices)
        this.answers.add(newAnswer)
    }

    fun getQuestions(): ArrayList<String>{
        return this.questions
    }
    fun getChoices(): ArrayList<ArrayList<String>>{
        return this.choices
    }
    fun getAnswers(): ArrayList<Int>{
        return this.answers
    }

}