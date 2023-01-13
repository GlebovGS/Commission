package com.example.myapplication.presentation.application_form_activities

data class Speciality(val facultyTitle:String,
                      val specialityCipher:String,
                      val specialityTitle:String,
                      val profiles:ArrayList<String>)

val specialityList1 = listOf<Speciality>(
    Speciality("Факультет компьютерных информационных технологий и автоматики","10.03.01","Информационная безопасность", arrayListOf("Информационная безопасность")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","11.03.02","Инфокоммуникационные технологии и системы связи", arrayListOf("Инфокоммуникационные технологии и системы связи")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","11.03.01","Радиотехника", arrayListOf("Радиотехника")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","11.03.04","Электроника и наноэлектроника", arrayListOf("Промышленная электроника")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","12.03.01","Приборостроение", arrayListOf("Информационно-измерительные технологии")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","15.03.04","Автоматизация технологических процессов и производств", arrayListOf("Автоматизация технологических процессов и производств в горно-металлургической отрасли")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","27.03.04","Управление в технических системах", arrayListOf("Управление и информатика в технических системах")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","27.03.04","Управление в технических системах", arrayListOf("Управление и информатика в технических системах")),
    Speciality("Факультет компьютерных информационных технологий и автоматики","21.05.04","Горное дело", arrayListOf("Электрификация и автоматизация горного производства")),
)