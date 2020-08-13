$p =New-Object -TypeName System.Diagnostics.ProcessStartInfo
$p.FileName ="{プログラム名}"
$p.WindowStyle =[System.Diagnostics.ProcessWindowStyle]::Maximized
[System.Diagnostics.Process]::Start($p)
