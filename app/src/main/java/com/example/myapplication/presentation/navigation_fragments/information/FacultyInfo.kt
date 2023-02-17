package com.example.myapplication.presentation.navigation_fragments.information

import com.example.myapplication.R

data class FacultyInfo(val logo:Int,val name:String, val site:String, val email:String, val emailPk:String, val phone1:String)


val facultyList = listOf(
    FacultyInfo(R.drawable.gf,"Горный факультет (ГФ)","http://gf.donntu.ru","gf@donntu.ru","gf_priem@donntu.ru", "071-323-80-26"),
    FacultyInfo(R.drawable.fnnz,"Факультет недропользования и наук о земле (ФННЗ)","http://ggf.donntu.ru","ggf@donntu.ru", "fnnz_priem@donntu.ru","071-345-71-91"),
    FacultyInfo(R.drawable.fimp,"Факультет интегрированных и мехатронных производств (ФИМП)","http://fimm.donntu.ru","decanat@fimm.donntu.ru", "fimp_priem@donntu.ru", "+7-949-371-08-65"),
    FacultyInfo(R.drawable.fmt,"Факультет металлургии и теплоэнергетики (ФМТ)","http://fmt.donntu.ru","fmt.donntu@mail.ru","fmt_priem@donntu.ru", "071-321-50-15"),
    FacultyInfo(R.drawable.fier,"Факультет интеллектуальной электроэнергетики и робототехники (ФИЭР)","http://fier.donntu.ru","decanat_etf@donntu.ru","fier_priem@donntu.ru", "071-352-13-76"),
    FacultyInfo(R.drawable.fisp,"Факультет интеллектуальных систем и программирования (ФИСП)","http://fisp.iknt.donntu.ru/","fisp@donntu.ru", "fisp_priem@donntu.ru", "071-009-03-04"),
    FacultyInfo(R.drawable.fist,"Факультет информационных систем и технологий (ФИСТ)","http://fist.iknt.donntu.ru","fist@donntu.ru", "fist_priem@donntu.ru", "071-332-13-04"),
    FacultyInfo(R.drawable.fkita,"Факультет компьютерных информационных технологий и автоматики (ФКИТА)","http://fkita.donntu.ru","decan@kita.donntu.ru", "fkita_priem@donntu.ru", "071-336-33-59"),
    FacultyInfo(R.drawable.ief,"Инженерно-экономический факультет (ИЭФ)","http://ief.donntu.ru","ief_donntu@mail.ru", "ief_priem@donntu.ru", "071-324-08-70"),
    FacultyInfo(R.drawable.iitzo,"Институт инновационных технологий заочного обучения (ИИТЗО)","http://iitzo.donntu.ru","yvk@donntu.ru", "z_priem@donntu.ru", "071-334-93-01")
)
