$ErrorActionPreference = "Stop"

Write-Host "Setting ANDROID_HOME..."
$env:ANDROID_HOME = "$env:LOCALAPPDATA\Android\Sdk"

Write-Host "Starting Appium Server in the background..."
$appiumJob = Start-Job -ScriptBlock {
    $env:ANDROID_HOME = "$env:LOCALAPPDATA\Android\Sdk"
    appium
}

Write-Host "Waiting 10 seconds for Appium to boot up..."
Start-Sleep -Seconds 10

Write-Host "Running Maven tests..."
try {
    mvn clean test
} finally {
    Write-Host "Stopping Appium Server..."
    Stop-Job -Job $appiumJob
    Remove-Job -Job $appiumJob
    Write-Host "Done!"
}
