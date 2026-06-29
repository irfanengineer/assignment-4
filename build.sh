#!/bin/bash

source data.txt
PROJECTS=$(ls projects 2>/dev/null)

cat > index.html <<EOL
<!DOCTYPE html>
<html>
<head>
<title>$NAME | Portfolio</title>

<style>
body {font-family: Arial; background:#0f172a; color:white;}
section {max-width:900px; margin:auto; padding:30px;}

.card {
  background:#1e293b;
  padding:20px;
  margin:15px 0;
  border-radius:10px;
}

.button {
  background:cyan;
  padding:10px 15px;
  text-decoration:none;
  color:black;
  margin-right:15px;
  display:inline-block;
}

.link-group {
  margin-top:15px;
}

</style>
</head>

<body>

<section>

<h1>$NAME</h1>
<p>$TITLE</p>

<h2>Projects</h2>
EOL

for p in $PROJECTS; do
echo "<div class='card'><h3>$p</h3></div>" >> index.html
done

cat >> index.html <<EOL

<h2>Links</h2>
<div class="link-group">
<a href="$GITHUB" class="button">GitHub</a>
<a href="$LINKEDIN" class="button">LinkedIn</a>
</div>

<p style="margin-top:10px;">Email: $EMAIL</p>

<h2>Resume</h2>
<a href="resume.pdf" class="button">Download Resume</a>

</section>
</body>
</html>
EOL

echo "✅ Clean professional site built"
