$(()=>{
    setupErrorHandler();
    valider()
});

function valider() {
    $.get("/validate", function (data) {
        if (data) {
            let ut = "<button class='btn btn-primary' id='btnRegistrerNy'>Registrer ny bil</button>" +
                "        <button class='btn btn-danger' id='btnSlettAlle'>Slett alle</button>" +
                "       <button class='btn btn-primary' id='loggUt'>Logg Ut</button>"
            $("#buttons").html(ut)
            hentInnlogget()
        } else {
            $("#buttons").html("<button class='btn btn-primary' id='loggInn'>Logg inn</button>")
            hentUtlogget()
        }
        eventlistener()
    })
}

const setupErrorHandler = () => {
    $.ajaxSetup({
        error: (data) => {
            $("#error").text(data.responseJSON.message)
        }
    })
}

const hentInnlogget = () => {
    $.get("/hent", function (data) {
        formaterData1(data)
    })
}

const hentUtlogget = () => {
    $.get("/hent", function (data) {
        formaterData2(data)
    })
}

const formaterData1 = eiere => {
    let ut = "<table class='table table-striped'><tr><th>Eiers personnummer</th><th>Eiers navn</th><th>Eiers adresse</th>" +
        "<th>Kjennetegn</th><th>Bilmerke</th><th>Biltype</th><th></th><th></th></tr>";
    for (const eier of eiere) {
        ut+="<tr><td>"+eier.persNr+"</td><td>"+eier.navn+"</td><td>"+eier.adresse+"</td>" +
            "<td>"+eier.kjennetegn+"</td><td>"+eier.bilmerke+"</td><td>"+eier.biltype+"</td>" +
            "<td><button class='btn btn-primary' id='"+eier.id+"Rediger'>Rediger</button></td>" +
            "<td><button class='btn btn-danger' id='"+eier.id+"Slett'>Slett</button></td></tr>";
    }
    ut+="</table>";
    $("#resultat").html(ut);

    addEventListeners(eiere);
}

const formaterData2 = eiere => {
    let ut = "<table class='table table-striped'><tr><th>Eiers personnummer</th><th>Eiers navn</th><th>Eiers adresse</th>" +
        "<th>Kjennetegn</th><th>Bilmerke</th><th>Biltype</th></tr>";
    for (const eier of eiere) {
        ut+="<tr><td>"+eier.persNr+"</td><td>"+eier.navn+"</td><td>"+eier.adresse+"</td>" +
            "<td>"+eier.kjennetegn+"</td><td>"+eier.bilmerke+"</td><td>"+eier.biltype+"</td>";
    }
    ut+="</table>";
    $("#resultat").html(ut);
}

const addEventListeners = eiere => {
    for (const eier of eiere){
        $("#"+eier.id+"Slett").on("click",() => slettEn(eier.id));
        $("#"+eier.id+"Rediger").on("click",() => rediger(eier.id));
    }
}
const eventlistener = () => {
    $("#loggInn").on("click", () => window.location.href="./login.html")
    $("#btnRegistrerNy").on("click",() => window.location.href="./registrer.html")
    $("#btnSlettAlle").on("click",() => {
        $.post("/slett", function(){
            hentInnlogget();
        })
    })
    $("#loggUt").on("click", () => {
        $.post("/logout", () => window.location.href="./motorvognRegister.html")
    })
}
const rediger = id => window.location.href = "./rediger.html?" + id

const slettEn = id =>{
    let url = "/slettEn?id="+id;
    $.get(url, () => {
        hentInnlogget();
    })
}