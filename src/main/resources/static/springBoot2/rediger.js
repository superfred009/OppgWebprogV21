$(() => {
    hentAlleBiler();
    hentEnMotorvogn();

    $("#btnRediger").click(() =>{

        const id = $("#id").val()
        const inPersNr = $("#eierPersnr").val()
        const inNavn = $("#eierNavn").val()
        const inAdresse = $("#eierAdresse").val()
        const inKjenne = $("#kjennetegn").val()
        const inMerke = $("#valgtMerke").val()
        const inType = $("#valgtType").val()

        let bilEier = {
            id: id,
            persNr: inPersNr,
            navn: inNavn,
            adresse: inAdresse,
            kjennetegn: inKjenne,
            bilmerke: inMerke,
            biltype: inType
        }

        if(inputval(bilEier)) {
            $.post("/redigerEn", bilEier, () => {
                console.log("Bil redigert")
                window.location.replace("./motorvognRegister.html");
            })
        } else {
            console.log("input mangler")
        }

    })

    $("#btnAvbryt").click(() => window.location.href = "./motorvognRegister.html");
})

const hentEnMotorvogn = () => {
    const id = window.location.search.substring(1);
    const url = "/hentEn?id=" + id;

    $.get(url, data => {
        $("#id").val(data.id)
        $("#eierPersnr").val(data.persNr)
        $("#eierNavn").val(data.navn)
        $("#eierAdresse").val(data.adresse)
        $("#kjennetegn").val(data.kjennetegn)
        $("#bilmerke").val(data.bilmerke)
        $("#biltype").val(data.biltype)
    })
}

const hentAlleBiler = () => $.get("/hentBiler", biler => formaterBiler(biler));

const formaterBiler = biler => {
    $("#valgtMerke").off(); //Fjerner eventlisteners på alle car objekter
    let ut = "<select id='valgtMerke'>";
    let forrigeMerke = "";
    ut += "<option>Velg merke</option>";
    for (const bil of biler) {
        if (bil.merke !== forrigeMerke) {
            ut += "<option>" + bil.merke + "</option>";
        }
        forrigeMerke = bil.merke;
    }
    ut += "</select>";
    $("#bilmerke").html(ut);

    addEventListeners(biler);
}

const finnTyper = () => {
    const valgtMerke = $("#valgtMerke").val()
    $.get("/hentBiler", biler => formaterTyper(biler, valgtMerke))
}

const formaterTyper = (biler, valgtMerke) => {
    let ut = "<select id='valgtType'>";
    for (const bil of biler) {
        if (bil.merke === valgtMerke) {
            ut += "<option>" + bil.type + "</option>";
        }
    }
    ut += "</select>";
    $("#biltype").html(ut);
}

const addEventListeners = biler => {
    for (const bil of biler){
        $("#valgtMerke").on("change",() => finnTyper());
    }
}


const inputval = bilEier => {
    let godkjent = true
    $("#persNrError").text("")
    if (bilEier.persNr === "") {
        $("#persNrError").text("Du må velge en film")
        godkjent = false
    }
    $("#navnError").text("")
    if (bilEier.navn === "") {
        $("#navnError").text("Du må skrive et tall")
        godkjent = false
    }
    $("#adresseError").text("")
    if (bilEier.adresse === "") {
        $("#adresseError").text("Du må skrive et fornavn")
        godkjent = false
    }
    $("#kjennetegnError").text("")
    if (bilEier.kjennetegn === "") {
        $("#kjennetegnError").text("Du må skrive et fornavn")
        godkjent = false
    }
    $("#merkeError").text("")
    if (bilEier.bilmerke === "") {
        $("#merkeError").text("Du må skrive et fornavn")
        godkjent = false
    }
    $("#typeError").text("")
    if (bilEier.biltype === "") {
        $("#typeError").text("Du må skrive et fornavn")
        godkjent = false
    }
    return godkjent;
}
