function logout() {
    localStorage.removeItem("accessToken")
    window.location.replace('/')
}