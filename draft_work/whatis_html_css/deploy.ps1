Set-Location $PSScriptRoot
$apache_bin = (Get-Command httpd).Source 
$apache = Split-Path -Parent $apache_bin | Split-Path -Parent
$htdocs = Join-Path $apache htdocs
$htdocs
if (Test-Path $htdocs) {
    Copy-Item -Path .\sample\komorikomasha\main\* $htdocs -Force -Recurse
    Copy-Item -Path .\sample\komorikomasha\test\* $htdocs -Force -Recurse
}




