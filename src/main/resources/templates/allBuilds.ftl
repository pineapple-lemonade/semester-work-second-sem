<#ftl encoding="UTF-8">
<#include 'base.ftl'>

<#macro title>
    <title>All Builds</title>
    <link rel="shortcut icon" href="/img_3.png" type="image/png">

</#macro>

<#macro content>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        window.onload = function showAll() {
            let request = new XMLHttpRequest()
            request.open('GET', '/handleBuilds', false)
            request.send()

            if (request.status !== 200) {
                alert("error")
            } else {
                let html = ""

                let response = JSON.parse(request.response)

                for (let i = 0; i < response.length; i++) {
                    html += "<a href='/builds/" + response[i]['id'] + "'/>"
                    html += "<div class='alert alert-dark' role='alert'>"
                    html += "<h2>" + response[i]['title'] + "</h2>"
                    html += "<div>" + response[i]['text'] + "</div>"
                    html += "<br>"
                    html += "<img src=\"" + response[i]['photoUrl'] + "\" width='665' height='350'>"
                    html += "<br><br>"
                    html += "<div><small class='text-muted'>" + response[i]['userNick'] + " " + response[i]['date'] +
                        "</small></div>"
                    html += "<div><small class='text-muted'>Build " + response[i]['id'] + "</small></div>"
                    html += "</div>" + "</a>"
                }
                document.getElementById('result').innerHTML = html
            }
        }

        function showResult(title) {
            const request = new XMLHttpRequest();
            request.open('GET', '/handleBuilds/' + title, true);
            request.send();


            let html = ""

            let response = JSON.parse(request.response)

            for (let i = 0; i < response.length; i++) {
                html += "<a href='/guides/" + response[i]['id'] + "'/>"
                html += "<div class='alert alert-dark' role='alert'>"
                html += "<h2>" + response[i]['title'] + "</h2>"
                html += "<div>" + response[i]['text'] + "</div>"
                html += "<br>"
                html += "<img src=\"" + response[i]['photoUrl'] + "\" width='665' height='350'>"
                html += "<br><br>"
                html += "<div><small class='text-muted'>" + response[i]['userNick'] + " " + response[i]['date'] +
                    "</small></div>"
                html += "<div><small class='text-muted'>Guide " + response[i]['id'] + "</small></div>"
                html += "</div>" + "</a>"
            }
            document.getElementById('result').innerHTML = html
        }
    </script>

    <br>
    <h1>All builds</h1>
    <br>

    <form>
        <p class="lead" id="1" style="float: left; margin-right: 50px;">
            Search for title:<br>
            <input name="title" type="text" onkeyup="showResult(this.value)"><br>
        </p>
    </form>

    <br>
    <br>
    <br>
    <br>

    <div id="result"></div>

</#macro>