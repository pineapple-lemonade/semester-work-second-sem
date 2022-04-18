<#ftl encoding='UTF-8'>
<#include 'base.ftl'>

<#macro title>
    <title>Add Build</title>
    <link rel="shortcut icon" href="/img_3.png" type="image/png">
</#macro>

<#macro content>
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
                <textarea name="text" placeholder="Build" class="recipe" style="width: 710px"></textarea>
            </label><br>
        </p>

        <p class="lead">
            <input name="photo" type="file"><br>
        </p>
        <br>
        <p class="lead"><input type="submit" value="Save"></p>
        <br>
    </form>
</#macro>