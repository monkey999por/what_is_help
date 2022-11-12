# https://monkey999por.hatenablog.com/entry/2020/08/28/114313
function Global:Copy-FileToSameName
{
    param(
        [Parameter(Mandatory, HelpMessage="‘—‚è‘¤")]
        [string]$source,

        [Parameter(Mandatory,HelpMessage="Žó‚¯‘¤")]
        [string]$destination
    )
    # is Exist ?
    $_source = [System.IO.FileInfo]::new("$(Convert-Path -Path $source)")
    $_destination = [System.IO.DirectoryInfo]::new("$(Convert-Path -Path $destination)")
    $file_list = [System.IO.Directory]::GetFiles(
        $_destination.FullName.Split("`""),
        $_source.Name.Split("`""),
        [System.IO.SearchOption]::AllDirectories)

    foreach ($item in $file_list)
    {
        if ($item -ne $_source.FullName.Split("`""))
        {
            Copy-Item -Path $_source.FullName.Split("`"") -Destination $item

        }
    }
}
