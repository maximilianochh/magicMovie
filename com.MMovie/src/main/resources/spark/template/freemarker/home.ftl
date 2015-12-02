<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Timeline">
    <#if user??>
    	<#if profileUser?? && user.id != profileUser.id>
    		<div class="followstatus">
    		<#if followed>
    			<a class="unfollow" href="/t/${profileUser.username}/unfollow">Unfollow user</a>
    		<#else>
    			<a class="follow" href="/t/${profileUser.username}/follow">Follow user</a>.
    		</#if>
    		</div>
    	<#elseif pageTitle != 'Public Timeline'>
    		<div class="twitbox">
        		<h3>What's on your mind ${user.username}?</h3>
        		<form action="/message" method="post">
          		<p><input type="text" name="text" size="60" maxlength="160"><!--
          		--><input type="submit" value="Share">
        		</form>
      		</div>
    	</#if>
    </#if>
</@layout.masterTemplate>