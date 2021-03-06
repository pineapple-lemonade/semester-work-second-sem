<#ftl encoding="UTF-8">
<#include 'base.ftl'>

<#macro title>
    <title>Build</title>
    <link rel="shortcut icon" href="/img_3.png" type="image/png">
</#macro>

<#macro content>

    <#if build?has_content>
        <br>
        <br>
        <br>
        <h1>${build.title}</h1>
        <br>
        <br>
        <img src="${build.photoUrl}" width="709" height="350">
        <br>
        <br>
        <br>
        <div>${build.text}</div>
        <br>
        <br>
        <br>
        <div>
            <table>
                <tr>
                    <td>
                        <a href="/users/${author.id}">
                            <img alt="user_img" src="${author.avatarUrl}" width="50" height="50" class="rounded-circle">
                        </a>
                    </td>

                    <td><strong style="font-size:20px">Nick: ${build.userNick}</strong></td>
                    <td><small class="text-muted" style="font-size:17px"><em>${build.date}</em></small></td>
                    <td><small class="text-muted" style="font-size:17px">Build ${build.id}</small></td>
                </tr>
            </table>
        </div>

        <br>

            <#if comments?has_content>
                <p class="lead">Comments:</p>
                <#list comments as comment>
                    <table>
                        <tr>
                            <td>
                                <a href="/users/${comment.userId}">
                                    <img alt="user_img" src="${comment.userAvatar}" width="50" height="50" class="rounded-circle">
                                </a>
                            </td>
                            <td><strong style="font-size:20px">Nick: ${comment.userNick}</strong></td>
                        </tr>
                    </table>
                    <div class="alert alert-dark" role="alert">
                        <div>${comment.text}</div>
                    </div>
                </#list>
            <#else>
                <p class="lead">No comments</p>
            </#if>

            <#if user?has_content>
                <form action="/comments/build/${build.id}" method="post" novalidate>
                    <p class="lead">Enter comment:</p>
                    <p class="lead">
                        <label>
                            <textarea name="text" placeholder="Comment" class="comment" style="width: 710px"></textarea>
                        </label><br>
                    </p>
                    <p class="lead"><input type="submit" value="Save"></p>
                    <br>
                </form>
            <#else>
                <p class="lead">Sign in to leave comments</p>
            </#if>
        </#if>

</#macro>