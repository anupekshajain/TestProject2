taskkill /im IRIS.Law.AccountsExe.exe /F

taskkill /im IRIS.Law.DesignerStudio.exe /F

taskkill /im IRIS.Law.DiaryExe.exe /F

taskkill /im IRIS.Law.DiaryReminders.exe /F

taskkill /im IRIS.Law.DmExe.exe /F

taskkill /im IRIS.Law.PmsExe.exe /F

taskkill /im IRIS.Law.TimeExe.exe /F

taskkill /im Legal.Solicitors.PurchaseLedger.AutoPayments.exe /F

taskkill /im Legal.Solicitors.PurchaseLedger.SupplierManager.exe /F

taskkill /im IRIS.Law.UtilityExe.exe /F

cd C:\Windows\Temp
del *.* /s /f /q

exit
