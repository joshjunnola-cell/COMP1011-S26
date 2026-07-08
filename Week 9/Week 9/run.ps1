$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$binDir = Join-Path $projectRoot "bin"
$sourceFile = Join-Path $projectRoot "src/Main.java"
$mysqlJar = Join-Path $projectRoot "lib/mysql-connector-j-8.4.0.jar"

if (-not (Test-Path $binDir)) {
    New-Item -ItemType Directory -Path $binDir -Force | Out-Null
}

javac -cp $mysqlJar -d $binDir $sourceFile
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

java -cp "$binDir;$mysqlJar" Main
