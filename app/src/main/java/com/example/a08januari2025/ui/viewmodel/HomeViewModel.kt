package com.example.a08januari2025.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a08januari2025.model.Mahasiswa
import com.example.a08januari2025.repository.MahasiswaRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

sealed class HomeUiState{
    data class Success(val mahasiswa: List<Mahasiswa>): HomeUiState()
    data class Error(val exception: Throwable): HomeUiState()
    object Loading: HomeUiState()
}

class HomeViewModel (
    private val mhs : MahasiswaRepository
): ViewModel() {
    var mhsUIState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getMhs()
    }

    fun getMhs(){
        viewModelScope.launch {
            mhs.getMahasiswa()
                .onStart {
                    mhsUIState = HomeUiState.Loading
                }
                .catch {
                    mhsUIState = HomeUiState.Error(it)
                }
                .collect{
                    mhsUIState = if (it.isEmpty()) {
                        HomeUiState.Error(Exception("Belum ada daftar mahasiswa"))
                    } else {
                        HomeUiState.Success(it)
                    }
                }
        }
    }
}