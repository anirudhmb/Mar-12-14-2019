<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script>
			$().ready(() => {
				
				$('#palindromebutton').on("click", () => {
					let word = $('#word').val();
					$.ajax({
						url: '/palindromecheck?word=' + word,
						type: 'POST',
						success(response) {
							$('#palindromemessage').text(response);
						}
					})
				});
				
				$('#anagrambutton').on("click", () => {
					let word = $('#word').val();
					$.ajax({
						url: '/getanagram?word=' + word,
						type: 'POST',
						success(response) {
							$('#anagrammessage').text(response)
						}
					})
				});
			});
		</script>
	</head>
	<body>
		<h1>Play with Words</h1>
		Word <input type="text" id="word"> <br/><br/>
		<hr/>
		<button type="button" id="palindromebutton">Check Palindrome</button>
		<button type="button" id="anagrambutton">Get Anagram</button>
		<h2 id="palindromemessage"></h2>
		<h2 id="anagrammessage"></h2>
	</body>
</html>