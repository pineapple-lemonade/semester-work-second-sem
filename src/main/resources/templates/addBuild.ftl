<#ftl encoding='UTF-8'>
<#include 'base.ftl'>

<#macro title>
    <title>Add Build</title>
    <link rel="shortcut icon" href="/img_3.png" type="image/png">
</#macro>

<#macro content>
    <script>
        function addItem(id) {
            document.getElementById("guide_items").innerHTML += "<td style='border-collapse: separate; border-spacing:0 1px'>" +
                document.getElementById(id).outerHTML +
                "</td>"
        }
    </script>
    <br>
    <h1>Build</h1>
    <br>
    <form action="/builds/add" method="post" novalidate enctype="multipart/form-data">
        <p class="lead">
            Enter title:<br>
            <input name="title" type="text" style="width: 710px"><br>
        </p>


        <p class="lead">
            Enter build:<br>
            <label>
                <textarea name="text" placeholder="Build" class="recipe" style="width: 710px; height: 410px"></textarea>
            </label><br>
        </p>

        <p class="lead">
            <input name="photo" type="file"><br>
        </p>
        <br>
        <p class="lead">Guide:</p>
        <div>
            <table>
                <tr id="guide_items">

                </tr>
            </table>
        </div>
        <br>
        <p class="lead">Items:</p>
        <div id="items">
            <table>
                <tr>
                    <td id="1" onclick="addItem(this.id)">
                        <img src="/8ed8edb4c_320x200.png" id="1" width="50" height="50" class="rounded-circle">
                    </td>
                    <td id="2" onclick="addItem(this.id)">
                        <img src="/Без названия.jpg" id="1" width="50" height="50" class="rounded-circle">
                    </td>
                    <td id="3" onclick="addItem(this.id)">
                        <img src="/Без названия (1).jpg" id="1" width="50" height="50" class="rounded-circle">
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <p class="lead"><input type="submit" value="Save"></p>
        <br>
    </form>
</#macro>