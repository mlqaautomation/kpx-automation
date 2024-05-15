package mlkpx.testSteps;

import org.testng.Assert;
import utilities.ExtentReport.ExtentReporter;

public class WS_ShopSafe_Steps extends Base_Steps{

    //-------------------Positive Test
    public void To_Validate_Shop_Safe_Page_WS_SS_01()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe button");
        if(isVisible(wsShopSafePageObjects.shopsafeTextheader(), "Shop Safe Button")){
            isVisible(wsShopSafePageObjects.referenceNoText(),"Reference No. Label");
            isVisible(wsShopSafePageObjects.referenceNoTxtbox(),"Reference No. Textbox Label");
            isVisible(wsShopSafePageObjects.searchBtn(), "Search Button");
            isVisible(wsShopSafePageObjects.scanQRCodeBtn(),"Scan QR Button");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Shop Safe Page");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Shop Safe Page");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Valid_Reference_Number_WS_SS_02()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            isVisible(wsShopSafePageObjects.TransactInfoText(),"TransactInfoText");
            isVisible(wsShopSafePageObjects.OriginText(),"OriginText");
            isVisible(wsShopSafePageObjects.DestinationText(),"DestinationText");
            isVisible(wsShopSafePageObjects.SellerText(),"SellerText");
            isVisible(wsShopSafePageObjects.BuyerText(),"BuyerText");
            isVisible(wsShopSafePageObjects.ItemDetailsText(),"ItemDetailsText");
            scrollToElement(wsShopSafePageObjects.PhotosText());
            isVisible(wsShopSafePageObjects.PhotosText(),"PhotosText");
            scrollToElement(wsShopSafePageObjects.SellerPhotosText());
            isVisible(wsShopSafePageObjects.SellerPhotosText(),"SellerPhotosText");
            scrollToElement(wsShopSafePageObjects.BuyerPhotosText());
            isVisible(wsShopSafePageObjects.BuyerPhotosText(),"BuyerPhotosText");
            scrollToElement(wsShopSafePageObjects.TransactionDetailsText());
            isVisible(wsShopSafePageObjects.TransactionDetailsText(),"TransactionDetailsText");
            isVisible(wsShopSafePageObjects.BuyerDetailsText(),"BuyerDetailsText");
            isVisible(wsShopSafePageObjects.SellerDetailsText(),"SellerDetailsText");
            isVisible(wsShopSafePageObjects.AmountInformationText(),"AmountInformationText");
            scrollToElement(wsShopSafePageObjects.TotalAmountText());
            isVisible(wsShopSafePageObjects.TotalAmountText(),"TotalAmountText");
            scrollToElement(wsShopSafePageObjects.ParcelStatusText());
            isVisible(wsShopSafePageObjects.ParcelStatusText(),"ParcelStatusText");
            scrollToElement(wsShopSafePageObjects.TrackingNoTextbox());
            isVisible(wsShopSafePageObjects.TrackingNoTextbox(),"TrackingNoTextbox");
            scrollToElement(wsShopSafePageObjects.RemarksTxtbox());
            isVisible(wsShopSafePageObjects.RemarksTxtbox(),"RemarksTxtbox");
            scrollToElement(wsShopSafePageObjects.BackBtn());
            isVisible(wsShopSafePageObjects.BackBtn(),"BackBtn");
            scrollToElement(wsShopSafePageObjects.UpdateStatusBtn());
            isVisible(wsShopSafePageObjects.UpdateStatusBtn(),"UpdateStatusBtn");
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            isVisible(wsShopSafePageObjects.PrintReceiptTxtBtn(),"PrintReceiptTxtBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Valid Reference Number");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Valid Reference Number");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Transaction_Information_WS_SS_03()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            waitSleep(2000);
            assertEqual(getText(wsShopSafePageObjects.OriginBranchVal()), propertyReader.getproperty("OriginVal"));
//            assertEqual(getValue(wsShopSafePageObjects.OperatorOriginVal()), propertyReader.getproperty("OperatorVal"));
            assertEqual(getText(wsShopSafePageObjects.DestinationBranchVal()), propertyReader.getproperty("DestinationBranchVal"));
//            assertEqual(getText(wsShopSafePageObjects.OperatorDestinationVal()), propertyReader.getproperty("OperatorDestinationVal"));
//            assertEqual(getText(wsShopSafePageObjects.DateTimeDestinationVal()), propertyReader.getproperty("DateTimeDestinationVal"));
            assertEqual(getText(wsShopSafePageObjects.SellerNameVal()), propertyReader.getproperty("SellerNameVal"));
            assertEqual(getText(wsShopSafePageObjects.SellerContactNoVal()), propertyReader.getproperty("SellerContactNoVal"));
            assertEqual(getText(wsShopSafePageObjects.BuyerNameVal()), propertyReader.getproperty("BuyerNameVal"));
            assertEqual(getText(wsShopSafePageObjects.BuyerContactNoVal()), propertyReader.getproperty("BuyerContactNoVal"));
            assertEqual(getText(wsShopSafePageObjects.ItemNameVal()), propertyReader.getproperty("ItemNameVal"));
            assertEqual(getText(wsShopSafePageObjects.ItemDescriptionVal()), propertyReader.getproperty("ItemDescriptionVal"));
            assertEqual(getText(wsShopSafePageObjects.BrandVal()), propertyReader.getproperty("BrandVal"));
            assertEqual(getText(wsShopSafePageObjects.ModelNoVal()), propertyReader.getproperty("ModelNoVal"));
            assertEqual(getText(wsShopSafePageObjects.CategoryVal()), propertyReader.getproperty("CategoryVal"));
            assertEqual(getText(wsShopSafePageObjects.WeightVal()), propertyReader.getproperty("WeightVal"));
            scrollToElement(wsShopSafePageObjects.NoItemsVal());
            assertEqual(getText(wsShopSafePageObjects.NoItemsVal()), propertyReader.getproperty("NoItemsVal"));
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Transaction Information");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Transaction Information");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Item_Photo_WS_SS_04()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.ItemPhotosVal());
            isVisible(wsShopSafePageObjects.ItemPhotosVal(),"ItemPhotoVal");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Item Photo");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Item Photo");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Sellers_Photo_WS_SS_05()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.IdFrontSellerVal());
            isVisible(wsShopSafePageObjects.IdFrontSellerVal(),"IdFrontSellerVal");
            isVisible(wsShopSafePageObjects.IdBackSellerVal(),"IdBackSellerVal");
            isVisible(wsShopSafePageObjects.CustomerPhotoSellerVal(),"CustomerPhotoSellerVal");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Sellers Photo");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Sellers Photo");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Buyer_Photo_WS_SS_06()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.IdFrontBuyerVal());
            isVisible(wsShopSafePageObjects.IdFrontBuyerVal(),"IdFrontBuyerVal");
            isVisible(wsShopSafePageObjects.IdBackBuyerVal(),"IdBackBuyerVal");
            isVisible(wsShopSafePageObjects.CustomerPhotoBuyerVal(),"CustomerPhotoBuyerVal");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Buyer Photo");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Buyer Photo");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Transaction_Details_WS_SS_07()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.IdTypeBuyerVal());
            isVisible(wsShopSafePageObjects.IdTypeBuyerVal(),"IdTypeBuyerVal");
            isVisible(wsShopSafePageObjects.IdNoBuyerVal(),"IdNoBuyerVal");
            isVisible(wsShopSafePageObjects.ExpiryDateBuyerVal(),"ExpiryDateBuyerVal");
            isVisible(wsShopSafePageObjects.VerficationLevelBuyerVal(),"VerficationLevelBuyerVal");
            isVisible(wsShopSafePageObjects.IdTypeSellerVal(),"IdTypeSellerVal");
            isVisible(wsShopSafePageObjects.IdNoSellerVal(),"IdNoSellerVal");
            isVisible(wsShopSafePageObjects.ExpiryDateSellerVal(),"ExpiryDateSellerVal");
            isVisible(wsShopSafePageObjects.VerficationLevelSellerVal(),"VerficationLevelSellerVal");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Transaction Details");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Transaction Details");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Amount_Information_WS_SS_08()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.ItemPriceVal());
            isVisible(wsShopSafePageObjects.ItemPriceVal(),"ItemPriceVal");
            isVisible(wsShopSafePageObjects.ShippingFeeVal(),"ShippingFeeVal");
            isVisible(wsShopSafePageObjects.ReturnShippingAndDepositVal(),"ReturnShippingAndDepositVal");
            isVisible(wsShopSafePageObjects.InsuranceFeeVal(),"InsuranceFeeVal");
            isVisible(wsShopSafePageObjects.ServiceFeeVal(),"ServiceFeeVal");
            isVisible(wsShopSafePageObjects.TotalAmountVal(),"TotalAmountVal");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Amount Information");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Amount Information");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Parcel_Status_As_Transit_WS_SS_09()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.StatusText());
            isVisible(wsShopSafePageObjects.StatusText(),"");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Parcel Status As Transit");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Parcel Status As Transit");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Input_Tracking_Number_And_Remarks_WS_SS_10()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            type(wsShopSafePageObjects.TrackingNoTextbox(), "Tracking Number Field",propertyReader.getproperty("TrackingNoTextbox"));
            type(wsShopSafePageObjects.RemarksTxtbox(), "Remarks Field",propertyReader.getproperty("RemarksTxtbox"));
            click(wsShopSafePageObjects.UpdateStatusBtn(), "UpdateStatusBtn");
            isVisible(wsShopSafePageObjects.UpdateStatus(), "UpdateStatus");
            isVisible(wsShopSafePageObjects.UpdateInfoText(), "UpdateInfoText");
            isVisible(wsShopSafePageObjects.YesBtn(), "Yes Button");
            isVisible(wsShopSafePageObjects.NoBtn(), "No Button");

            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Input Tracking Number And Remarks");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Input Tracking Number And Remarks");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Update_Status_By_Clicking_Yes_Button_For_Transit_WS_SS_11()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field","" );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            type(wsShopSafePageObjects.TrackingNoTextbox(), "Tracking Number Field","" );
            type(wsShopSafePageObjects.RemarksTxtbox(), "Remarks Field","" );
            click(wsShopSafePageObjects.UpdateStatusBtn(), "");
            //click(wsShopSafePageObjects.YesBtn(), "");

            // status modal

            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Update Status By Clicking Yes Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Update Status By Clicking Yes Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Parcel_Status_As_Ready_for_Pick_Up_WS_SS_12()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field","" );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.StatusText());
            isVisible(wsShopSafePageObjects.StatusText(),"");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Parcel Status As Ready for Pick-Up");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Parcel Status As Ready for Pick-Up");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Input_Remarks_And_Clicking_Update_Status_Button_For_PickUp_WS_SS_13()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field","" );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            type(wsShopSafePageObjects.TrackingNoTextbox(), "Tracking Number Field","" );
            type(wsShopSafePageObjects.RemarksTxtbox(), "Remarks Field","" );
            click(wsShopSafePageObjects.UpdateStatusBtn(), "");

            // status modal

            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Parcel Status As Transit");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Parcel Status As Transit");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Parcel_Status_As_Transit_WS_SS_14()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field","" );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            type(wsShopSafePageObjects.TrackingNoTextbox(), "Tracking Number Field","" );
            type(wsShopSafePageObjects.RemarksTxtbox(), "Remarks Field","" );
            click(wsShopSafePageObjects.UpdateStatusBtn(), "");
            //click(wsShopSafePageObjects.YesBtn(), "");

            // status modal

            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Parcel Status As Transit");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Parcel Status As Transit");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Clicking_Complete_Button_For_PickUp_WS_SS_15()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field","" );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.PrintReceiptTxtBtn());
            type(wsShopSafePageObjects.TrackingNoTextbox(), "Tracking Number Field","" );
            type(wsShopSafePageObjects.RemarksTxtbox(), "Remarks Field","" );
            click(wsShopSafePageObjects.UpdateStatusBtn(), "");
            click(wsShopSafePageObjects.CompleteBtn(), "");

            // status modal

            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validate Parcel Status As Transit");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Parcel Status As Transit");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    //-----------------Negative  Test
    public void To_Validate_Empty_Reference_Number_WS_RR_01()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            isVisible(wsShopSafePageObjects.emptyErrorMessage(),"emptyErrorMessage");
            assertEqual(getText(wsShopSafePageObjects.emptyErrorMessage()), propertyReader.getproperty("emptyErrorMessage"));
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Empty Reference Number");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Empty Reference Number");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Invalid_Reference_Number_WS_RR_02()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeInvalidKPTN" ));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.NotFoundText(),"NotFoundText")){
            isVisible(wsShopSafePageObjects.NotFoundText(),"NotFoundText");
            isVisible(wsShopSafePageObjects.ReferenceNoNotFound(),"ReferenceNoNotFound");
            isVisible(wsShopSafePageObjects.OkBtn(),"OkBtn");
            click(wsShopSafePageObjects.OkBtn(), "ClickOkBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Empty Reference Number");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Empty Reference Number");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Empty_Tracking_Number_WS_RR_03()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.UpdateStatusBtn());
            click(wsShopSafePageObjects.UpdateStatusBtn(), "UpdateStatusBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Empty Tracking Number");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Empty Tracking Number");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Modal_Display_By_Clicking_Back_Button_WS_RR_04()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.BackBtn());
            click(wsShopSafePageObjects.BackBtn(),"BackBtn");
            isVisible(wsShopSafePageObjects.CancelShopSafeUpdateText(),"CancelShopSafeUpdateText");
            isVisible(wsShopSafePageObjects.CancelShopSafeUpdateNoteText(),"CancelShopSafeUpdateNoteText");
            isVisible(wsShopSafePageObjects.YesDoNotUpdateBtn(),"YesDoNotUpdateBtn");
            isVisible(wsShopSafePageObjects.NoStayOnThisPageBtn(),"NoStayOnThisPageBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Modal Display By Clicking Back Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Modal Display By Clicking Back Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Back_To_Wallet_Services_Page_WS_RR_05()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.BackBtn());
            click(wsShopSafePageObjects.BackBtn(),"BackBtn");
            click(wsShopSafePageObjects.YesDoNotUpdateBtn(),"YesDoNotUpdateBtn");
            isVisible(wsShopSafePageObjects.shopsafeTextheader(), "shopsafeTextheader");
            isVisible(wsShopSafePageObjects.referenceNoTxtbox(), "referenceNoTxtbox" );
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Modal Display By Clicking Back Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Modal Display By Clicking Back Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Stay_In_The_Page_WS_RR_06()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.BackBtn());
            click(wsShopSafePageObjects.BackBtn(),"BackBtn");
            click(wsShopSafePageObjects.NoStayOnThisPageBtn(),"NoStayOnThisPageBtn");
            isVisible(wsShopSafePageObjects.BackBtn(), "BackBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Modal Display By Clicking Back Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Modal Display By Clicking Back Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Stay_In_The_Page_WS_RR_07()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN") );
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.BackBtn());
            click(wsShopSafePageObjects.BackBtn(),"BackBtn");
            click(wsShopSafePageObjects.YesDoNotUpdateBtn(),"YesDoNotUpdateBtn");
            click(wsCashInToOwnAccountPageObjects.walletServicesLink(), "Wallet Services Page ");
            isVisible(wsCashInToOwnAccountPageObjects.walletServicesText(),"walletServicesText");
            isVisible(wsCashInToOwnAccountPageObjects.searchButton(),"searchButton");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Modal Display By Clicking Back Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Modal Display By Clicking Back Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

    public void To_Validate_Stay_In_The_Page_WS_RR_08()throws Exception{
        click(wsShopSafePageObjects.walletServicesLink(), "Wallet Services Page ");
        click(wsShopSafePageObjects.shopsafeText(), "Shop Safe Button");
        type(wsShopSafePageObjects.referenceNoTxtbox(), "Reference Number Field",propertyReader.getproperty("shopSafeValidKPTN"));
        click(wsShopSafePageObjects.searchBtn(), "Search Button");
        waitSleep(3000);
        if(isVisible(wsShopSafePageObjects.shopsafeTextNextheader(), "Shop Safe Header")){
            scrollToElement(wsShopSafePageObjects.BackBtn());
            click(wsShopSafePageObjects.BackBtn(),"BackBtn");
            click(wsShopSafePageObjects.NoStayOnThisPageBtn(),"NoStayOnThisPageBtn");
            isVisible(wsShopSafePageObjects.BackBtn(), "BackBtn");
            ExtentReporter.logPass("Shop Safe Page navigation", "Successfully Validated Modal Display By Clicking Back Button");
        }else{
            ExtentReporter.logFail("Shop Safe Page navigation", "Failed to Validate Modal Display By Clicking Back Button");
            Assert.fail("Failed to Validate Shop Safe Page");
        }
    }

}