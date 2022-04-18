<#ftl encoding="UTF-8">
<#include 'base.ftl'>

<#macro title>
    <title>Guide</title>
    <link rel="shortcut icon" href="/img_3.png" type="image/png">
</#macro>

<#macro content>
    <br>
    <#if user??>
        <p class="lead"><a href="/myGuides"><- Back</a></p>
    <#else>
        <p class="lead"><a href="/guides"><- Back</a></p>
    </#if>
    <br>

    <#if guide?has_content>
        <br>
        <br>
        <h1>${guide.title}</h1>
        <br>
        <br>
        <br>
        <img src="${guide.photoUrl}" width="709" height="350">
        <br>
        <br>
        <br>
        <div>${guide.text}</div>
        <br>
        <div>
            <table>
                <tr>
                    <td>
                        <a href="/users/${user.id}">
                            <img alt="user_img" src="${user.avatarUrl}" width="50" height="50" class="color-square">
                        </a>
                    </td>

                    <td><strong style="font-size:20px">Nick: ${guide.userNick}</strong></td>
                    <td><small class="text-muted" style="font-size:17px"><em>${guide.date}</em></small></td>
                    <td><small class="text-muted" style="font-size:17px">Guide ${guide.id}</small></td>
                </tr>
            </table>
        </div>

        <br>

        <#if isComments??>
            <#if comments?has_content>
                <p class="lead">Comments:</p>
                <#list comments as comment>
                    <table>
                        <tr>
                            <td>
                                <a href="/users/${comment.user.id}">
                                    <img alt="user_img" src="${comment.user.avatarUrl}" width="50" height="50" class="color-square">
                                </a>
                            </td>
                            <td><strong style="font-size:20px">Nick: ${comment.user.nick}</strong></td>
                        </tr>
                    </table>
                    <div class="alert alert-dark" role="alert">
                        <div>${comment.text}</div>
                    </div>
                </#list>
            <#else>
                <p class="lead">Comments Missmatch Exception!</p>
            </#if>

            <#if user?has_content>
                <form action="/guides/${guide.id}" method="post" novalidate>
                    <p class="lead">Insert comment:</p>
                    <p class="lead">
                        <label>
                            <textarea name="comment" placeholder="Comment" class="comment" style="width: 710px"></textarea>
                        </label><br>
                    </p>
                    <p class="lead"><input type="submit" value="Save"></p>
                    <br>
                </form>
            <#else>
                <p class="lead">Sign In to leave comments</p>
            </#if>
        </#if>
    <#else>
        <p class="lead">Something went wrong</p>
    </#if>

</#macro>