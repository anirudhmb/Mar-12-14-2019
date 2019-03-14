<html>
	<body>
		<h1>Play with Words</h1>
		<form action="/palindromecheck" method="POST">
			Word <input type="text" name="word"> 
			<br/>
			<button>Check Palindrome</button>
			<h2>${palindromemessage}</h2>
		</form>
		<hr/>
		<form action="/getanagram" method="POST">
			Word <input type="text" name="word"> 
			<br/>
			<button>Get Anagram</button>
			<h2>${anagrammessage}</h2>
		</form>
	</body>
</html>