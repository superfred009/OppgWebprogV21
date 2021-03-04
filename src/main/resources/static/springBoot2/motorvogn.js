function registrer() {

    const inPersNr = $("#eierPersnr").val()
    const inNavn = $("#eierNavn").val()
    const inAdresse = $("#eierAdresse").val()
    const inKjenne = $("#kjennetegn").val()
    const inMerke = $("#bilmerke").val()
    const inType = $("#biltype").val()

    $("#feilmelding").html("")
    let feilmelding = false
    if(!inPersNr || !inNavn || !inAdresse || !inKjenne || !inMerke || !inType) {
        $("#feilmelding").html("Du må fylle inn alle feltene")
        feilmelding = true
    }
    if (feilmelding){
        return
    }

    let bilEier = {
        persNr: inPersNr,
        navn: inNavn,
        adresse: inAdresse,
        kjennetegn: inKjenne,
        bilmerke: inMerke,
        biltype: inType
    }

    $.post("/lagre", bilEier, function () {
        hent()
    })
    $("#eierPersnr").val("")
    $("#eierNavn").val("")
    $("#eierAdresse").val("")
    $("#kjennetegn").val("")
    $("#bilmerke").val("")
    $("#biltype").val("")
}

function hent() {
    $.get("/hent", function (data) {
        formaterData(data)
    })
}

function formaterData(eiere) {
    let ut = "<table class='table table-striped'><tr><th>Eiers personnummer</th><th>Eiers navn</th><th>Eiers adresse</th>" +
        "<th>Kjennetegn</th><th>Bilmerke</th><th>Biltype</th></tr>";
    for (const eier of eiere) {
        ut+="<tr><td>"+eier.persNr+"</td><td>"+eier.navn+"</td><td>"+eier.adresse+"</td>" +
            "<td>"+eier.kjennetegn+"</td><td>"+eier.bilmerke+"</td><td>"+eier.biltype+"</td></tr>";
    }
    ut+="</table>";
    $("#resultat").html(ut);
}

function slettBiler(){
    $.post("/slett", function(){
        $("#resultat").html("");
    })
}