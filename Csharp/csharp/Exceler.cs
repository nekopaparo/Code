using NPOI.SS.UserModel;
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller.Core
{
    class Exceler
    {
        private IWorkbook Workbook { get; set; } = null;

        public bool Open(string fileName)
        {
            FileStream fileStream = new FileStream(fileName, FileMode.Open, FileAccess.Read);
            if (Workbook != null)
            {
                Workbook.Close();
            }
            switch (Path.GetExtension(fileName))
            {
                // 2007版本 
                case ".xlsx":
                    Workbook = new NPOI.XSSF.UserModel.XSSFWorkbook(fileStream);
                    break;
                // 2003版本 
                case ".xls":
                    Workbook = new NPOI.HSSF.UserModel.HSSFWorkbook(fileStream);
                    break;
                default:
                    Workbook = null;
                    break;
            }
            fileStream.Dispose();
            return Workbook != null;
        }

        public ISheet GetSheet(string sheetName = null)
        {
            if (sheetName == null)
            {
                return Workbook?.GetSheetAt(0);
            }
            else
            {
                return Workbook?.GetSheet(sheetName);
            }
        }

        public List<List<string>> GetData(string sheetName = null)
        {
            List<List<string>> datas = new List<List<string>>();
            ISheet sheet = GetSheet(sheetName);
            IRow row;
            for (int i = 1; i <= sheet.LastRowNum; i++)
            {
                List<string> data= new List<string>();
                if ((row = sheet.GetRow(i)) != null)
                {
                    for (int j = 0; j < row.LastCellNum; j++)
                    {
                        data.Add(row.GetCell(j).ToString());
                    }
                }
                datas.Add(data);
            }
            return datas;
        }

        public void Write(string path)
        {
            FileStream file = new FileStream(path, FileMode.Create);//產生檔案
            Workbook.Write(file);
            file.Dispose();
        }
    }
}
