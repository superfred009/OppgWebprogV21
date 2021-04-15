$(()=>{
    hent()
});

export function hent() {
    $.get("/hent", function (data) {
        formaterData(data)
    })
}

function formaterData(eiere) {
    let ut = "<table class='table table-striped'><tr><th>Eiers personnummer</th><th>Eiers navn</th><th>Eiers adresse</th>" +
        "<th>Kjennetegn</th><th>Bilmerke</th><th>Biltype</th><th></th><th></th></tr>";
    for (const eier of eiere) {
        ut+="<tr><td>"+eier.persNr+"</td><td>"+eier.navn+"</td><td>"+eier.adresse+"</td>" +
            "<td>"+eier.kjennetegn+"</td><td>"+eier.bilmerke+"</td><td>"+eier.biltype+"</td>" +
            "<td><button class='btn btn-primary' onclick='rediger( \"" + eier.id + "\")'>Rediger</button></td>" +
            "<td><button class='btn btn-danger' onclick='slettEn( \"" + eier.id + "\")'>Slett</button></td></tr>";
    }
    ut+="</table>";
    $("#resultat").html(ut);
}

function slettBiler(){
    $.post("/slett", function(){
        hent();
    })
}

function rediger(id){

}

function slettEn(id){
    let url = "/slettEn?id="+id;
    $.get(url, function(){
        hent();
    })
}