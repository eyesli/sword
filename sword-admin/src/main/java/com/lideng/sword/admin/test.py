import xlwt
import pymysql


connect = pymysql.Connect(host='localhost',port=3306,user='root',passwd='root',db='sword',charset='utf8')
cursor = connect.cursor()

results=[]
for row in range(2):
    sql="select * from sys_role_"+str(row)
    print(sql)
    cursor.execute(sql)
    results+=cursor.fetchall()
    print(results)
fields = cursor.description

workbook = xlwt.Workbook()
sheet = workbook.add_sheet("table_name", cell_overwrite_ok=True)
for field in range(0, len(fields)):
    sheet.write(0, field, fields[field][0])
    row = 1
    col = 0
    for row in range(1,len(results)+1):
        for col in range(0, len(fields)):
                sheet.write(row, col, u'%s' % results[row-1][col])
workbook.save("/Users/admin/Desktop/test.xls")


