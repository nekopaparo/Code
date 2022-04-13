// 建立資料夾
if (System.IO.Directory.Exists("D:\\dir") == false)
{
    System.IO.Directory.CreateDirectory("D:\\dir");
    System.Console.WriteLine("建立資料夾");
}
// 開啟資料夾
try
{
    System.Diagnostics.Process.Start("explorer.exe", "D:\\dir");
}
catch { }
// 刪除資料夾
try
{
    Microsoft.VisualBasic.FileIO.FileSystem.DeleteDirectory(
        "D:\\dir",
        Microsoft.VisualBasic.FileIO.UIOption.OnlyErrorDialogs,
        Microsoft.VisualBasic.FileIO.RecycleOption.SendToRecycleBin);
}
catch { System.Console.Write("刪除失敗"); }


// 結合位置
System.IO.Path.Combine(path1, path2) // = path1 + path2
/*  取得系統特殊資料夾目錄路徑
    LocalApplicationData = \AppData\Local
    https://docs.microsoft.com/dotnet/api/system.environment.specialfolder */
System.Environment.GetFolderPath(System.Environment.SpecialFolder.LocalApplicationData);
