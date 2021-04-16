$(()=>{
    hent()

    $("#btnRegistrerNy").click(() => window.location.href="./registrer.html")

    $("#btnSlettAlle").click(() => {
        $.post("/slett", function(){
            hent();
        })
    })
});

const hent = () => {
    $.get("/hent", function (data) {
        formaterData(data)
    })
}

const formaterData = eiere => {
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

const addEventListeners = eiere => {
    for (const eier of eiere){
        $("#"+eier.id+"Slett").on("click",() => slettEn(eier.id));
        $("#"+eier.id+"Rediger").on("click",() => rediger(eier.id));
    }
}

const rediger = id => window.location.href = "./rediger.html?" + id

const slettEn = id =>{
    let url = "/slettEn?id="+id;
    $.get(url, () => {
        hent();
    })
}