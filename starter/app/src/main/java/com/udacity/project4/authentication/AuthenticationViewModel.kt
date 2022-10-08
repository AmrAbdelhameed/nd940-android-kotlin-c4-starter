package com.udacity.project4.authentication

class AuthenticationViewModel {
    private val repository = AuthenticationRepository()

    fun getAuthenticationState() = repository.getFirebaseAuthState()

    fun logout() = repository.signOut()
}