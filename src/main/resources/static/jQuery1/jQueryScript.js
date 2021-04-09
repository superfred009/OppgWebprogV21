$(function(){
    console.log("Website loaded")

    // Oppgave 1
    $("#viseKnapp").click(function(){
        let innNavn2 = $("#navn").val()
        let innAlder2 = $("#alder").val()

        if (isNaN(innAlder2 || innAlder2<1)) {
            $("#errorMeldingAlder").text("Du må skrive et tall")
        } else {
            $("#errorMeldingAlder").text("")
            $("#visnavnogalder").html("Navn: "+innNavn2+"<br>Alder: "+innAlder2)
        }
    })

    // Oppgave 2

    $("#konverterC").click(function(){
        $("#konverterprint").html("")
        let C = $("#ctilf").val()
        let F = (9/5)*C+32
        $("#konverterprint").html(C+' grader Celsius er '+F+' grader i fahrenheit')
    })
    $("#konverterF").click(function(){
        $("#konverterprint").html("")
        let F = $("#ftilc").val()
        let C = (5/9)*(F-32)
        $("#konverterprint").html(F+' grader Fahrenheit er '+C+' grader i Celsius')
    })

    // Oppgave 3

    $("#pluss").click(function() {
        $("#svar").html('')
        $("#errorTall").text("")
        let tall1 = Number($("#tall1").val())
        let tall2 = Number($("#tall2").val())
        let svar = ''
        if (isNaN(tall1) || isNaN(tall2)){
            $("#errorTall").text("Du må skrive tall i begge feltene")
        } else {
            svar = tall1 + tall2
            $("#svar").html(tall1+' + '+tall2+' = '+svar)
        }
    })
    $("#minus").click(function() {
        $("#svar").html('')
        $("#errorTall").text("")
        let tall1 = Number($("#tall1").val())
        let tall2 = Number($("#tall2").val())
        let svar = ''
        if (isNaN(tall1) || isNaN(tall2)){
            $("#errorTall").text("Du må skrive tall i begge feltene")
        } else {
            svar = tall1 - tall2
            $("#svar").html(tall1+' - '+tall2+' = '+svar)
        }
    })
    $("#gange").click(function() {
        $("#svar").html('')
        $("#errorTall").text("")
        let tall1 = Number($("#tall1").val())
        let tall2 = Number($("#tall2").val())
        let svar = ''
        if (isNaN(tall1) || isNaN(tall2)){
            $("#errorTall").text("Du må skrive tall i begge feltene")
        } else {
            svar = tall1 * tall2
            $("#svar").html(tall1+' * '+tall2+' = '+svar)
        }
    })
    $("#dele").click(function() {
        $("#svar").html('')
        $("#errorTall").text("")
        let tall1 = Number($("#tall1").val())
        let tall2 = Number($("#tall2").val())
        let svar = ''
        if (isNaN(tall1) || isNaN(tall2)){
            $("#errorTall").text("Du må skrive tall i begge feltene")
        } else {
            svar = tall1 / tall2
            $("#svar").html(tall1+' / '+tall2+' = '+svar)
        }
    })

    // Oppgave 4

    const personregister = []

})