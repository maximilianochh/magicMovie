<#macro masterTemplate title="Welcome">
    <!DOCTYPE html
            PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
		<div class="page">
	  		<h1>Magic Movie: You are a Movie Wizard</h1>
		  	<div class="navigation">
		  	<#if user??>
		    	<a href="/">my timeline</a> |
		    	<a href="/logout">sign out [${user.username}]</a>
		  	<#else>
			    <a href="/public">home</a> |
			    <a href="/register">sign up</a> |
			    <a href="/login">sign in</a>
		  	</#if>
		  	</div>
		  	<div class="body">
		  		<#nested />
		  	</div>
		</div>
    </body>
    </html>
</#macro>