$(()=>{
    $("#avbryt").click(() => window.location.href="./motorvognRegister.html")
    $("#loggeInn").click(() => login())
})

const login = () => {
    const bruker = {
        brukernavn : $("#brukernavn").val(),
        passord : $("#passord").val()
    }
    $.post("/login", bruker, (innlogget) => {
        if (innlogget) {
            window.location.href = "./motorvognRegister.html"
        } else {
            $("#error").text("Feil brukernavn eller passord")
        }
    })
        .fail(() => {
            $("#error").text("Serverveil - prøv igjen senere")
        })
}