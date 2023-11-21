package com.example.quickity.ui.screens

import android.content.Context
import androidx.navigation.NavController
import com.example.quickity.Viewmodels.HomeViewModel
import com.example.quickity.models.Employee

    fun addEmployeeInDB(
        context: Context,
        navController: NavController,
        employee: Employee,
        homeViewModel: HomeViewModel
    ) {
        homeViewModel.addEmployee(employee)
        navController.popBackStack()
    }