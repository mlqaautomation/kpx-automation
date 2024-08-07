package utilities.yamlReader;
import org.yaml.snakeyaml.Yaml;
import utilities.ExtentReport.ExtentReporter;
import utilities.Logger.LoggingUtils;
import java.util.List;
import java.io.*;
import java.util.*;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class yamlReader {
    /**
     * The YAML file name.
     */
    private String yamlFileName;

    /**
     * The YAML object.
     */
    private Map<String, Object> yamlData;
    private String filePath;
    private String randomValueFromCIOA_TC_09;
    private String username;
    private List<String> randomGeneratedResourceID;

    public yamlReader() {
        this.filePath = ".\\src\\test\\java\\resources\\testData.yaml";
        this.yamlFileName = this.filePath;
        yamlLoader();
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private void yamlLoader() {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream);
            if (yamlData == null) {
                yamlData = new LinkedHashMap<>();
            }
        } catch (FileNotFoundException e) {
            LoggingUtils.error(e.getMessage());
        }
    }

    public Map<String, Object> getRoleData(String role) {
        List<Map<String, Object>> roles = (List<Map<String, Object>>) yamlData.get("Roles");
        for (Map<String, Object> r : roles) {
            String rRole = (String) r.get("role");
            if (role.equals(rRole)) {
                return r;
            }
        }
        return null;
    }

    public String getEmailByRole(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return (String) roleData.get("gmail_email");
        }
        return null;
    }

    public String getPasswordByRole(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return (String) roleData.get("gmail_password");
        }
        return null;
    }

    public String getKpxUsername(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return roleData.get("kpx_username").toString();
        }
        return null;
    }

    public String getKpxPassword(String role) {
        Map<String, Object> roleData = getRoleData(role);
        if (roleData != null) {
            return roleData.get("kpx_password").toString();
        }
        return null;
    }
    public String getUsernameInActiveAccount(String credentials) {
        Map<String, Object> roleData = getRoleData(credentials);
        if (roleData != null) {
            return roleData.get("inactive_username").toString();
        }
        return null;
    }
    public String getPasswordInActiveAccount(String credentials) {
        Map<String, Object> roleData = getRoleData(credentials);
        if (roleData != null) {
            return roleData.get("inactive_password").toString();
        }
        return null;
    }

    public String getPasswordNewBranch(String credentials) {
        Map<String, Object> roleData = getRoleData(credentials);
        if (roleData != null) {
            return roleData.get("password").toString();
        }
        return null;
    }

    public List<Map<String, Object>> getSendersData() {
        return (List<Map<String, Object>>) yamlData.get("Senders");
    }

    public Map<String, Object> getRandomSenderData() {
        List<Map<String, Object>> senders = getSendersData();
        Random random = new Random();
        int randomIndex = random.nextInt(senders.size());
        return senders.get(randomIndex);
    }

    public String[] getRandomName() {
        Map<String, Object> randomSender = getRandomSenderData();
        Map<String, Object> kycData = (Map<String, Object>) randomSender.get("kyc");
        String firstName = (String) kycData.get("firstName");
        String lastName = (String) kycData.get("lastName");
        return new String[]{firstName, lastName};
    }

    public List<Map<String, Object>> getSenderSendOutPartnerData() {
        return (List<Map<String, Object>>) yamlData.get("SenderForSendOutPartner");
    }

    public Map<String, Object> getRandomSenderSendOutPartnerData() {
        List<Map<String, Object>> senderSendOutPartner = getSenderSendOutPartnerData();
        Random random = new Random();
        int randomIndex = random.nextInt(senderSendOutPartner.size());
        return senderSendOutPartner.get(randomIndex);
    }

    public String[] getRandomNameForSenderSendOutPartner() {
        Map<String, Object> randomNameForSenderSendOutPartner = getRandomSenderSendOutPartnerData();
        Map<String, Object> kycData = (Map<String, Object>) randomNameForSenderSendOutPartner.get("kyc");
        String firstName = (String) kycData.get("firstName");
        String lastName = (String) kycData.get("lastName");
        return new String[]{firstName, lastName};
    }

    //    public String[] getRandomNameAddNewReciever() {
//        Map<String, Object> randomSender = getRandomSenderData();
//        Map<String, Object> kycData = (Map<String, Object>) randomSender.get("kyc");
//        String firstName = (String) kycData.get("firstName");
//        String lastName = (String) kycData.get("lastName");
//        return new String[]{firstName, lastName};
//    }
    public String getSendOutKPTNCompliance() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("sendOutKPTNCompliance");
            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out KPTN Compliance values available.");
                return null;
            }

            String selectedSendOutKptn = sendOutKptnList.get(sendOutKptnList.size() - 1); // Select the last stored send out KPTN
            sendOutKptnList.remove(sendOutKptnList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void getRandomResourceID(String value) {
        try {
            String cleanedValue = value.replaceAll("\\[|\\]", "");
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            yamlData.put("passWordNewBranchUser", value);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(value + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getGenerateUsername(String value) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            yamlData.put("usernameNewBranchUser", value);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(value + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsernameNewBranchUser() {
        String usernameNewBranchUser = null;
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> data = yaml.load(fileInputStream);

            if (data.containsKey("usernameNewBranchUser")) {
                usernameNewBranchUser = (String) data.get("usernameNewBranchUser");
            } else {
                ExtentReporter.logFail("getUsernameNewBranchUser ","Failed to getUsernameNewBranchUser");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usernameNewBranchUser;
    }
    public String getPasswordNewBranchUser() {
        String passwordNewBranchUser = null;
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> data = yaml.load(fileInputStream);

            if (data.containsKey("passWordNewBranchUser")) {
                Object passWordNewBranchUser = data.get("passWordNewBranchUser");
                if (passWordNewBranchUser instanceof String) {
                    String password = (String) passWordNewBranchUser;
                    // Remove both square brackets and quotation marks from the password
                    passwordNewBranchUser = password.replaceAll("[\\[\\]\"]", "");
                }
            } else {
                ExtentReporter.logFail("getPasswordNewBranchUser ","Failed to getPasswordNewBranchUser");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return passwordNewBranchUser;
    }



    public String getSendOutKPTN() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("sendOutKPTN");
            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out KPTN values available.");
                return null;
            }

            String selectedSendOutKptn = sendOutKptnList.get(sendOutKptnList.size() - 1); // Select the last stored send out KPTN
            sendOutKptnList.remove(sendOutKptnList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSendOutWatchlistPartnerNum() {
        try {
            List<String> sendOutReferenceList = (List<String>) yamlData.get("WesternUnionPartnerWatchlistKPTN");
            if (sendOutReferenceList == null || sendOutReferenceList.isEmpty()) {
                System.out.println("No Sendout Watchlist Reference values available.");
                return null;
            }

            String selectedSendOutReference = sendOutReferenceList.get(sendOutReferenceList.size() - 1); // Select the last stored send out KPTN
            sendOutReferenceList.remove(sendOutReferenceList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutReference;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSendOutReferenceNum() {
        try {
            List<String> sendOutReferenceList = (List<String>) yamlData.get("WesternUnionPartner10Minute");
            if (sendOutReferenceList == null || sendOutReferenceList.isEmpty()) {
                System.out.println("No Sendout Reference values available.");
                return null;
            }

            String selectedSendOutReference = sendOutReferenceList.get(sendOutReferenceList.size() - 1); // Select the last stored send out KPTN
            sendOutReferenceList.remove(sendOutReferenceList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutReference;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSendOutReferenceNumRemote() {
        try {
            List<String> sendOutReferenceList = (List<String>) yamlData.get("WesternUnionPartner10MinuteRemote");
            if (sendOutReferenceList == null || sendOutReferenceList.isEmpty()) {
                System.out.println("No Sendout Reference remote values available.");
                return null;
            }

            String selectedSendOutReference = sendOutReferenceList.get(sendOutReferenceList.size() - 1); // Select the last stored send out KPTN
            sendOutReferenceList.remove(sendOutReferenceList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutReference;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSendOutRemoteKPTN() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("remoteSendoutKPTN");

            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out remote KPTN values available.");
                return null;
            }

            String selectedSendOutKptn = sendOutKptnList.get(sendOutKptnList.size() - 1); // Select the last stored send out KPTN
            sendOutKptnList.remove(sendOutKptnList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void writeReqNumData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("RequestNumber", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WesternUnionPartnerWatchlistKPTN(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("WesternUnionPartnerWatchlistKPTN", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataCompliance(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("sendOutKPTNCompliance", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
    public String getSendOutForChange() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("sendOutKPTN");

            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out for change KPTN values available.");
                return null;
            }

            String selectedSendOutKptn = sendOutKptnList.get(sendOutKptnList.size() - 1); // Select the last stored send out KPTN
            sendOutKptnList.remove(sendOutKptnList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSendOutPartnerMoneygram10Min() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("MoneyGramPartner10Minute");

            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out moneygram partner 10mins KPTN values available.");
                return null;
            }

            String selectedSendOutKptn = sendOutKptnList.get(sendOutKptnList.size() - 1); // Select the last stored send out KPTN
            sendOutKptnList.remove(sendOutKptnList.size() - 1); // Remove the selected send out KPTN from the list
            saveYamlData();
            return selectedSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRandomLNames() {
        try {
            List<String> randomList = (List<String>) yamlData.get("WatchlistLName");
            if (randomList == null || randomList.isEmpty()) {
                System.out.println("No Random L Names available.");
                return null;
            }

            String selectedRandom = randomList.get(randomList.size() - 1);
            randomList.remove(randomList.size() - 1);
            saveYamlData();
            return selectedRandom;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRandomFNames() {
        try {
            List<String> randomList = (List<String>) yamlData.get("WatchlistFName");
            if (randomList == null || randomList.isEmpty()) {
                System.out.println("No Random F Names available.");
                return null;
            }

            String selectedRandom = randomList.get(randomList.size() - 1);
            randomList.remove(randomList.size() - 1);
            saveYamlData();
            return selectedRandom;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCompanyName() {
        try {
            List<String> randomList = (List<String>) yamlData.get("WatchlistCompanyName");
            if (randomList == null || randomList.isEmpty()) {
                System.out.println("No Random Company Name available.");
                return null;
            }

            String selectedRandom = randomList.get(randomList.size() - 1);
            randomList.remove(randomList.size() - 1);
            saveYamlData();
            return selectedRandom;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getMobileNumber() {
        try {
            List<String> randomList = (List<String>) yamlData.get("WatchlistMobileNumber");
            if (randomList == null || randomList.isEmpty()) {
                System.out.println("No Random Mobile Numbers available.");
                return null;
            }

            String selectedRandom = randomList.get(randomList.size() - 1);
            randomList.remove(randomList.size() - 1);
            saveYamlData();
            return selectedRandom;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void refreshTestData() {
        try {
            // Load the test data from the testdata.yaml file
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream);

            // Perform any necessary data refresh operations
            // ...

            // Save the updated test data back to the testdata.yaml file
            saveYamlData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getBillsPayKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("billsPayKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("remoteBillsPayKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCignalKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CignalBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Cignal BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayGentradeKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("GentradeBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Gentrade BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayGentrade1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("GentradeBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Gentrade BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayIsabelKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("IsabelWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Isabel Water BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayIsabel1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("IsabelWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Isabel Water BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayLagunaKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("LagunaWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Laguna Water BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayPowerCycleKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("PowerCycleBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Power Cycle BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayPowerCycle1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("PowerCycleBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Power Cycle BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBaviCTGKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BaviCTGBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BAVI-CTG BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBaviCTG1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BaviCTGBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BAVI_CTG BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCOTELCO1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CotelcoBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No COTELCO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCOTELCOKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CotelcoBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No COTELCO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMACROCEBUKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MacroCebuBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No MACRO CEBU BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayHELPMATETALISAYKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("HelpmateTalisayBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No HELPMATE TALISAY BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMLJEWELLERSKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MLJewellersBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No ML JEWELLERS BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayEIGHTCHAMPKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("EightChampBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No EightChamp BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayGOLDENBRIAKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("GoldenBriaBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Golden Bria BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySAMELCOKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("Samelco1BPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SAMELCO 1 BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySOCOTECOIIKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SocotecoIIBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SOCOTECO II BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMOELCIKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MoelciBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No MOELCI 1 BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayRMGCORPKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("RMGCorpBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("NoRMG CORPORATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMETROWATERKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MetroWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No METRO WATER BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySTIWestKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("STIWestNegrosBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No STI West Negros BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayIPICEBUKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("IPICebuBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No IPI-CEBU BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCEBUINSTITUTETECHKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CEBUInstituteTechBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Cebu Institute Technology BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySEMIGIRECORPKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SemigireCorpBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SEMIGIRE CORPORATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayHONDAMOTORKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("HONDAMotorBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No HONDA MOTOR BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayVECOKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("VECOBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No VECO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayZCWATERDISTRICTKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("ZCWaterDistrictBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No ZC WATER DISTRICT BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCENTROESCOLARKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CENTROEscolarBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No CENTRO ESCOLAR BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySANTAPharmaKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SANTAPharmaBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SANTAPharma BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCARMONAKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CARMONABPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No CARMONA BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBBBROTHERSPHINCKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BBBrothersPhIncBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BBBrothers PH INC. BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMETROBANKVisayanKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("METROBANKVisayanBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No METROBANK Visayan BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayJOHNFOUNDATIONKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("JOHNFoundationBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No JOHN FOUNDATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPay123LENDINGKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("123LendingBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBREADANDMOREKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BREADAndMoreBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBREADANDMORE1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BREADAndMoreBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPay123LENDING1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("123LendingBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayJOHNFOUNDATION1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("JOHNFoundationBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No JOHN FOUNDATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMETROBANKVisayan1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("METROBANKVisayanBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No METROBANK Visayan BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayBBBROTHERSPHINC1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("BBBrothersPhIncBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No BBBrothers PH INC. BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCARMONA1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CARMONABPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No CARMONA BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySANTAPharma1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SANTAPharmaBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SANTAPharma BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCENTROESCOLAR1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CENTROEscolarBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No CENTRO ESCOLAR BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayZCWATERDISTRICT1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("ZCWaterDistrictBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No ZC WATER DISTRICT BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayVECO1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("VECOBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No VECO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayHONDAMOTOR1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("HONDAMotorBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No HONDA MOTOR BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySEMIGIRECORP1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SemigireCorpBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SEMIGIRE CORPORATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCEBUINSTITUTETECH1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CEBUInstituteTechBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Cebu Institute Technology BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayIPICEBU1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("IPICebuBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No IPI-CEBU BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySTIWest1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("STIWestNegrosBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No STI West Negros BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMETROWATER1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MetroWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No METRO WATER BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayRMGCORP1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("RMGCorpBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("NoRMG CORPORATION BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMOELCI1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MoelciBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No MOELCI 1 BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySOCOTECOII1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("SocotecoIIBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SOCOTECO II BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPaySAMELCO1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("Samelco1BPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No SAMELCO 1 BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayGOLDENBRIA1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("GoldenBriaBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Golden Bria BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayEIGHTCHAMP1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("EightChampBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No EightChamp BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMLJEWELLERS1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MLJewellersBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No ML JEWELLERS BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBillsPayHELPMATETALISAY1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("HelpmateTalisayBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No HELPMATE TALISAY BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayMACROCEBU1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("MacroCebuBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No MACRO CEBU BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBillsPayLaguna1KPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("LagunaWaterBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No Laguna Water BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCignalKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CignalRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Cignal BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayGentradeKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("GentradeRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Gentrade BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayGentrade1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("GentradeRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Gentrade BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayIsabelKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("IsabelWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Isabel Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayIsabel1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("IsabelWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Isabel Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayLagunaKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("LagunaWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Laguna Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayPowerCycleKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("PowerCycleRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Laguna Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayPowerCycle1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("PowerCycleRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Laguna Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBavi_CTG1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BaviCTGRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Bavi_CTG BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCOTELCO1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CotelcoRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote COTELCO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCOTELCOKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CotelcoRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote COTELCO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMACROCEBUKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MacroCebuRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote MACRO CEBU BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayHELPMATETALISAYKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("HelpmateTalisayRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote HELPMATE TALISAY BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMLJEWELLERSKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MLJewellersRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote ML JEWELLERS BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayEIGHTCHAMPKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("EightChampRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote EightChamp BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayGOLDENBRIAKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("GoldenBriaRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Golden Bria BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySAMELCOKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("Samelco1RemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SAMELCO 1 BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySOCOTECOIIKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SocotecoIIRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SOCOTECO II BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMOELCIKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MoelciRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote MOELCI 1 BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayRMGCORPKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("RMGCorpRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote RMG CORPORATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMETROWATERKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MetroWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote METRO WATER BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySTIWestKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("STIWestNegrosRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote STI West Negros BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayIPICEBUKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("IPICebuRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote IPI-CEBU BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCEBUINSTITUTETECHKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CEBUInstituteTechRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Cebu Institute Tech BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySEMIGIRECORPKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SemigireCorpRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SEMIGIRE CORPORATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayHONDAMOTORKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("HONDAMotorRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote HONDA MOTOR BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayVECOKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("VECORemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote VECO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayZCWATERDISTRICTKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("ZCWaterDistrictRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote ZC Water District BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCENTROESCOLARKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CENTROEscolarRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote CENTRO ESCOLAR BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySANTAPharmaKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SANTAPharmaRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SANTAPharma BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCARMONAKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CARMONARemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote CARMONA BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBBBROTHERSPHINCKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BBBrothersPhIncRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BBROTHERS PH INC. BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMETROBANKVisayanKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("METROBANKVisayanRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote METROBANK Visayan BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayJOHNFOUNDATIONKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("JOHNFoundationRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote JOHN FOUNDATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPay123LendingKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("123LendingRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBREADANDMOREKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BREADAndMoreRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBREADANDMORE1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BREADAndMoreRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPay123Lending1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("123LendingRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayJOHNFOUNDATION1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("JOHNFoundationRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote JOHN FOUNDATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMETROBANKVisayan1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("METROBANKVisayanRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote METROBANK Visayan BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBBBROTHERSPHINC1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BBBrothersPhIncRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BBROTHERS PH INC. BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCARMONA1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CARMONARemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote CARMONA BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySANTAPharma1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SANTAPharmaRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SANTAPharma BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCENTROESCOLAR1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CENTROEscolarRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote CENTRO ESCOLAR BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayZCWATERDISTRICT1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("ZCWaterDistrictRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote ZC Water District BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayVECO1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("VECORemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote VECO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayHONDAMOTOR1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("HONDAMotorRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote HONDA MOTOR BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySEMIGIRECORP1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SemigireCorpRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SEMIGIRE CORPORATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCEBUINSTITUTETECH1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CEBUInstituteTechRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Cebu Institute Tech BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayIPICEBU1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("IPICebuRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote IPI-CEBU BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySTIWest1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("STIWestNegrosRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote STI West Negros BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMETROWATER1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MetroWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote METRO WATER BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayRMGCORP1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("RMGCorpRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote RMG CORPORATION BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMOELCI1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MoelciRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote MOELCI 1 BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySOCOTECOII1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("SocotecoIIRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SOCOTECO II BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPaySAMELCO1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("Samelco1RemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote SAMELCO 1 BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayGOLDENBRIA1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("GoldenBriaRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Golden Bria BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayEIGHTCHAMP1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("EightChampRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote EightChamp BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMLJEWELLERS1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MLJewellersRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote ML JEWELLERS BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayHELPMATETALISAY1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("HelpmateTalisayRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote HELPMATE TALISAY BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayMACROCEBU1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("MacroCebuRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote MACRO CEBU BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayBavi_CTGKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("BaviCTGRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Bavi_CTG BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayLaguna1KPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("LagunaWaterRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Laguna Water BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayCEBECOKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("CebecoRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote Cebeco BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayNORDECOKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("NordecoBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No NORDECO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayNORDECOKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("NordecoRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote NORDECO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayPagibigKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("PagibigBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No NORDECO BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            BillsPayKptnList.remove(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteBillsPayPagibigKPTN() {
        try {
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("PagibigRemoteBPKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote NORDECO BillsPay KPTN values available.");
                return null;
            }
            String selectBillsPayKptn = RemoteBillsPayKptnList.get(RemoteBillsPayKptnList.size() - 1);
            RemoteBillsPayKptnList.remove(RemoteBillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayCEBECOKPTN() {
        try {
            List<String> BillsPayKptnList = (List<String>) yamlData.get("CebecoBPKTPN");

            if (BillsPayKptnList == null || BillsPayKptnList.isEmpty()) {
                System.out.println("No CEBECO III BillsPay KPTN values available.");
                return null;
            }


            String selectBillsPayKptn = BillsPayKptnList.get(BillsPayKptnList.size() - 1);
            saveYamlData();
            return selectBillsPayKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getBillsPayAmount() {
        try {
            int randomAmount = new Random().nextInt(2000) + 1000;
            return String.valueOf(randomAmount);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPartnerSendoutAmount() {
        try {
            int randomAmount = new Random().nextInt(1001) + 500;
            return String.valueOf(randomAmount);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPayoutKPTN() {
        try {
            List<String> payoutkptnList = (List<String>) yamlData.get("payoutKPTN");
            if (payoutkptnList == null || payoutkptnList.isEmpty()) {
                System.out.println("No payoutKPTN values available.");
                return null;
            }
            String selectPayoutKPTN = payoutkptnList.get(payoutkptnList.size() - 1);
            payoutkptnList.remove(payoutkptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPayoutReference() {
        try {
            List<String> payoutreferenceList = (List<String>) yamlData.get("payoutReference");
            if (payoutreferenceList == null || payoutreferenceList.isEmpty()) {
                System.out.println("No payout Reference values available.");
                return null;
            }
            String selectPayoutRef = payoutreferenceList.get(payoutreferenceList.size() - 1);
            payoutreferenceList.remove(payoutreferenceList.size() - 1);
            saveYamlData();
            return selectPayoutRef;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getPayoutRemoteReference() {
        try {
            List<String> payoutreferenceList = (List<String>) yamlData.get("payoutRemoteReference");
            if (payoutreferenceList == null || payoutreferenceList.isEmpty()) {
                System.out.println("No payout Reference values available.");
                return null;
            }
            String selectPayoutRef = payoutreferenceList.get(payoutreferenceList.size() - 1);
            payoutreferenceList.remove(payoutreferenceList.size() - 1);
            saveYamlData();
            return selectPayoutRef;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSuccessPayoutKPTN() {
        try {
            List<String> kptnList = (List<String>) yamlData.get("payoutReference");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No payoutKPTN values available.");
                return null;
            }

            String selectPayoutKPTN = kptnList.get(kptnList.size() - 1);
            kptnList.remove(kptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSuccessRemotePayoutKPTN() {
        try {
            List<String> kptnList = (List<String>) yamlData.get("payoutRemoteReference");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No remote payoutKPTN values available.");
                return null;
            }

            String selectPayoutKPTN = kptnList.get(kptnList.size() - 1);
            kptnList.remove(kptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSuccessPayoutWesternKPTN() {
        try {
            List<String> kptnList = (List<String>) yamlData.get("payoutReference");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No payout Western KPTN values available.");
                return null;
            }

            String selectPayoutKPTN = kptnList.get(kptnList.size() - 1);
            kptnList.remove(kptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSuccessPayoutRemoteWesternKPTN() {
        try {
            List<String> kptnList = (List<String>) yamlData.get("payoutReference");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No payout Western KPTN values available.");
                return null;
            }

            String selectPayoutKPTN = kptnList.get(kptnList.size() - 1);
            kptnList.remove(kptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemotePayoutKPTN() {
        try {
            List<String> kptnList = (List<String>) yamlData.get("remotePayoutKPTN");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No remote payoutKPTN values available.");
                return null;
            }
//
            String selectPayoutKPTN = kptnList.get(kptnList.size() - 1);
            kptnList.remove(kptnList.size() - 1);
            saveYamlData();
            return selectPayoutKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteKPTN() {
        try {
            List<String> remoteKptnList = (List<String>) yamlData.get("remoteSendoutKPTN");

            if (remoteKptnList == null || remoteKptnList.isEmpty()) {
                System.out.println("No remote KPTN values available.");
                return null;
            }

            String randomRemoteKptn = remoteKptnList.get(remoteKptnList.size() - 1);
            remoteKptnList.remove(remoteKptnList.size() - 1);
            saveYamlData();
            return randomRemoteKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getWatchlistKPTN() {
        try {
            List<String> remoteKptnList = (List<String>) yamlData.get("WatchlistKPTN");

            if (remoteKptnList == null || remoteKptnList.isEmpty()) {
                System.out.println("No remote KPTN values available.");
                return null;
            }

            String randomRemoteKptn = remoteKptnList.get(remoteKptnList.size() - 1);
            remoteKptnList.remove(remoteKptnList.size() - 1);
            saveYamlData();
            return randomRemoteKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRemoteWatchlistKPTN() {
        try {
            List<String> remoteKptnList = (List<String>) yamlData.get("RemoteWatchlistKPTN");

            if (remoteKptnList == null || remoteKptnList.isEmpty()) {
                System.out.println("No remote KPTN values available.");
                return null;
            }

            String randomRemoteKptn = remoteKptnList.get(remoteKptnList.size() - 1);
            remoteKptnList.remove(remoteKptnList.size() - 1);
            saveYamlData();
            return randomRemoteKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRandomWriteCashIn_Kptn() {
        try {
            List<String> referenceNumList = (List<String>) yamlData.get("CashInKTPN");
            if (referenceNumList == null || referenceNumList.isEmpty()) {
                System.out.println("No Cash In KPTN available.");
                return null;
            }
            String randomIndex =  referenceNumList.get(referenceNumList.size()- 1);
            referenceNumList.remove(referenceNumList.size() - 1);

            saveYamlData();
            return randomIndex;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRandomCashOutReferenceNum() {
        try {
            List<String> cashOutReferenceNumList = (List<String>) yamlData.get("CashOutKTPN");
            if (cashOutReferenceNumList == null || cashOutReferenceNumList.isEmpty()) {
                System.out.println("No Random Cash Out Reference Number available.");
                return null;
            }
            String randomCashOutReferenceNum = cashOutReferenceNumList.get(cashOutReferenceNumList.size()- 1);
            cashOutReferenceNumList.remove(cashOutReferenceNumList.size() - 1);
            saveYamlData();
            return randomCashOutReferenceNum;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getRandomKPPReferenceNum() {
        try {
            List<String> kppReferenceNumList = (List<String>) yamlData.get("KwartaPadalaKTPN");
            if (kppReferenceNumList == null || kppReferenceNumList.isEmpty()) {
                System.out.println("No Kwarta Padala Reference Number available.");
                return null;
            }
            String randomKPPReferenceNum = kppReferenceNumList.get(kppReferenceNumList.size()- 1);
            kppReferenceNumList.remove(kppReferenceNumList.size() - 1);
            saveYamlData();
            return randomKPPReferenceNum;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCIAReprintKPTN() {
        try {
            List<String> CIAKptnList = (List<String>) yamlData.get("CIAReprintKPTN");

            if (CIAKptnList == null || CIAKptnList.isEmpty()) {
                System.out.println("No CIAReprintKPTN values available.");
                return null;
            }

            int lastIndex = CIAKptnList.size() - 1;
            String CIAKptn = CIAKptnList.get(lastIndex);
            return CIAKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCIOKptn() {
        try {
            List<String> CIAKptnList = (List<String>) yamlData.get("CIOReprintKPTN");

            if (CIAKptnList == null || CIAKptnList.isEmpty()) {
                System.out.println("No CIAReprintKPTN values available.");
                return null;
            }


            int lastIndex = CIAKptnList.size() - 1;
            String CIOKptn = CIAKptnList.get(lastIndex);
            return CIOKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCashoutKptn() {
        try {
            List<String> CIAKptnList = (List<String>) yamlData.get("COReprintKPTN");

            if (CIAKptnList == null || CIAKptnList.isEmpty()) {
                System.out.println("No Cashout KPTN values available.");
                return null;
            }


            int lastIndex = CIAKptnList.size() - 1;
            String CIOKptn = CIAKptnList.get(lastIndex);
            return CIOKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getKPReprintKPTN() {
        try {
            List<String> KPKptnList = (List<String>) yamlData.get("KPReprintKPTN");

            if (KPKptnList == null || KPKptnList.isEmpty()) {
                System.out.println("No KPReprintKPTN KPTN values available.");
                return null;
            }

            int lastIndex = KPKptnList.size() - 1;
            String randomSendOutKptn = KPKptnList.get(lastIndex);
            return randomSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void saveYamlData() {
        try {
            Yaml yaml = new Yaml();
            Writer writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    public void writeKptnData(List<String> values) {
//        try {
//            Yaml yaml = new Yaml();
//            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
//            Map<String, Object> yamlData = yaml.load(fileInputStream);
//
//            if (yamlData.containsKey("sendOutKPTN")) {
//                List<String> existingValues = (List<String>) yamlData.get("sendOutKPTN");
//                existingValues.addAll(values);
//            } else {
//                yamlData.put("sendOutKPTN", values);
//            }
//
//            FileWriter writer = new FileWriter(yamlFileName);
//            yaml.dump(yamlData, writer);
//            LoggingUtils.info(values + " saved to file");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public void writeCWKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("WatchlistKPTN", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCWRemoteKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("RemoteWatchlistKPTN", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("sendOutKPTN", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeReferenceNumData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("WesternUnionPartner10MinuteRemote")) {
                List<String> existingValues = (List<String>) yamlData.get("WesternUnionPartner10MinuteRemote");
                existingValues.addAll(values);
            } else {
                yamlData.put("WesternUnionPartner10MinuteRemote", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataMoneygramPartner10MinuteService(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("MoneyGramPartner10Minute", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataMoneygramPartner10MinuteServiceRemote(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("MoneyGramPartner10MinuteRemote", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataWesternUnionPartner10MinuteService(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("WesternUnionPartner10Minute", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataWesternUnionPartner10MinuteServiceRemote(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("WesternUnionPartner10MinuteRemote", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKptnDataMoneygramPartnerAccountDeposit(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            yamlData = yaml.load(fileInputStream); // Assign the loaded YAML data to the class member

            yamlData.put("MoneyGramPartnerAccountDeposit", values); // Overwrite the existing values with the new values

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeRemoteKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("remoteSendoutKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("remoteSendoutKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("remoteSendoutKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writePayoutReferenceData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("payoutReference")) {
                List<String> existingValues = (List<String>) yamlData.get("payoutReference");
                existingValues.addAll(values);
            } else {
                yamlData.put("payoutReference", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writePayoutRemoteReferenceData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("payoutRemoteReference")) {
                List<String> existingValues = (List<String>) yamlData.get("payoutRemoteReference");
                existingValues.addAll(values);
            } else {
                yamlData.put("payoutRemoteReference", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writePayoutKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("payoutKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("payoutKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("payoutKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeRemotePayoutKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("remotePayoutKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("remotePayoutKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("remotePayoutKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("billsPayKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("billsPayKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("billsPayKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCignalKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CignalBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CignalBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CignalBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayGentradeKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("GentradeBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("GentradeBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("GentradeBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayIsabelKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("IsabelWaterBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("IsabelWaterBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("IsabelWaterBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayLagunaKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("LagunaWaterBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("LagunaWaterBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("LagunaWaterBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayPowerCycleKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("PowerCycleBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("PowerCycleBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("PowerCycleBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayBaviCTGKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("BaviCTGBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("BaviCTGBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("BaviCTGBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCOTELCOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CotelcoBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CotelcoBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CotelcoBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayMACROCEBUKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("MacroCebuBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("MacroCebuBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("MacroCebuBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayHELPMATETALISAYKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("HelpmateTalisayBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("HelpmateTalisayBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("HelpmateTalisayBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayMLJEWELLERSKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("MLJewellersBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("MLJewellersBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("MLJewellersBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayEIGHTCHAMPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("EightChampBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("EightChampBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("EightChampBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayGOLDENBRIAKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("GoldenBriaBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("GoldenBriaBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("GoldenBriaBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPaySAMELCO1KptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("Samelco1BPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("Samelco1BPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("Samelco1BPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPaySOCOTECOIIKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("SocotecoIIBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("SocotecoIIBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("SocotecoIIBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayMOELCIKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("MoelciBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("MoelciBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("MoelciBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRMGCORPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("RMGCorpBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("RMGCorpBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("RMGCorpBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayMETROWATERKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("MetroWaterBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("MetroWaterBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("MetroWaterBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPaySTIWESTKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("STIWestNegrosBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("STIWestNegrosBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("STIWestNegrosBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayIPICEBUKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("IPICebuBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("IPICebuBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("IPICebuBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCEBUINSTITUTETECHKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CEBUInstituteTechBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CEBUInstituteTechBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CEBUInstituteTechBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPaySEMIGIRECORPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("SemigireCorpBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("SemigireCorpBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("SemigireCorpBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayHONDAMOTORKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("HONDAMotorBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("HONDAMotorBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("HONDAMotorBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayVECOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("VECOBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("VECOBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("VECOBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayZCWATERDISTRICTKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("ZCWaterDistrictBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("ZCWaterDistrictBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("ZCWaterDistrictBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCENTROESCOLARKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CENTROEscolarBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CENTROEscolarBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CENTROEscolarBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPaySANTAPharmaKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("SANTAPharmaBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("SANTAPharmaBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("SANTAPharmaBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCARMONAKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CARMONABPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CARMONABPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CARMONABPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayBBBROTHERSPHINCKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("BBBrothersPhIncBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("BBBrothersPhIncBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("BBBrothersPhIncBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayMETROBANKVISAYANKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("METROBANKVisayanBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("METROBANKVisayanBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("METROBANKVisayanBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayJOHNFOUNDATIONKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("JOHNFoundationBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("JOHNFoundationBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("JOHNFoundationBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPay123LENDINGKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("123LendingBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("123LendingBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("123LendingBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayBREADANDMOREKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("BREADAndMoreBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("BREADAndMoreBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("BREADAndMoreBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeBillsPayPagibigKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("PagibigBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("PagibigBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("PagibigBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayNordecoKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("NordecoBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("NordecoBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("NordecoBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayCEBECOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CebecoBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CebecoBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CebecoBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteNordecoKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("NordecoRemoteBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("NordecoRemoteBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("NordecoRemoteBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemotePagibigKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("PagibigRemoteBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("PagibigRemoteBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("PagibigRemoteBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteCEBECOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CebecoRemoteBPKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CebecoRemoteBPKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("CebecoRemoteBPKTPN", trimmedValues);
            }
            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeRemoteBillsPayKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

//            if (yamlData.containsKey("remoteBillsPayKTPN")) {
//                List<String> existingValues = (List<String>) yamlData.get("remoteBillsPayKTPN");
//                existingValues.addAll(values);
//            } else {
//                yamlData.put("remoteBillsPayKTPN", values);
//            }
            if (yamlData.containsKey("remoteBillsPayKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("remoteBillsPayKTPN");
                for (String value : values) {
                    existingValues.add(value.replace(" ", ""));
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    trimmedValues.add(value.replace(" ", ""));
                }
                yamlData.put("remoteBillsPayKTPN", trimmedValues);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBillsPayRemoteCignalKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("CignalRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("CignalRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("CignalRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteGentradeKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("GentradeRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("GentradeRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("GentradeRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteIsabelKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("IsabelWaterRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("IsabelWaterRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("IsabelWaterRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteLagunaKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("LagunaWaterRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("LagunaWaterRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("LagunaWaterRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemotePowerCycleKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("PowerCycleRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("PowerCycleRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("PowerCycleRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteBaviCTGKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("BaviCTGRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("BaviCTGRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("BaviCTGRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteCOTELCOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("CotelcoRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("CotelcoRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("CotelcoRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteMACROCEBUKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("MacroCebuRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("MacroCebuRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    // Cast the Object to List<String>
                    @SuppressWarnings("unchecked")
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    // Handle the case where "CignalRemoteBPKTPN" is not a List
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("MacroCebuRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteHELPMATETALISAYKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("HelpmateTalisayRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("HelpmateTalisayRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("HelpmateTalisayRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteMLJEWELLERSKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("MLJewellersRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("MLJewellersRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("MLJewellersRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteEIGHTCHAMPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("EightChampRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("EightChampRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("EightChampRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteGOLDENBRIAKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("GoldenBriaRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("GoldenBriaRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("GoldenBriaRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteSAMELCO1KptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("Samelco1RemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("Samelco1RemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("Samelco1RemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteSOCOTECOIIKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("SocotecoIIRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("SocotecoIIRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("SocotecoIIRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteMOELCIKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("MoelciRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("MoelciRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("MoelciRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteRMGCORPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("RMGCorpRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("RMGCorpRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("RMGCorpRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteMETROWATERKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("MetroWaterRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("MetroWaterRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("MetroWaterRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteSTIWESTKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("STIWestNegrosRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("STIWestNegrosRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("STIWestNegrosRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteIPICEBUKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("IPICebuRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("IPICebuRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("IPICebuRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteCEBUINSTITUTETECHKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("CEBUInstituteTechRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("CEBUInstituteTechRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("CEBUInstituteTechRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteSEMIGIRECORPKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("SemigireCorpRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("SemigireCorpRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("SemigireCorpRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteHONDAMOTORKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("HONDAMotorRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("HONDAMotorRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("HONDAMotorRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteVECOKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("VECORemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("VECORemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("VECORemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteZCWATERDISTRICTKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("ZCWaterDistrictRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("ZCWaterDistrictRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("ZCWaterDistrictRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteCENTROESCOLARKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("CENTROEscolarRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("CENTROEscolarRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("CENTROEscolarRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteSANTAPharmaKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("SANTAPharmaRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("SANTAPharmaRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("SANTAPharmaRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteCARMONAKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("CARMONARemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("CARMONARemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("CARMONARemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteBBBROTHERSPHINCKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("BBBrothersPhIncRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("BBBrothersPhIncRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("BBBrothersPhIncRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteMETROBANKVisayanKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("METROBANKVisayanRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("METROBANKVisayanRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("METROBANKVisayanRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteJOHNFOUNDATIONKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("JOHNFoundationRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("JOHNFoundationRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("JOHNFoundationRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemote123LENDINGKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("123LendingRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("123LendingRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("123LendingRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBillsPayRemoteBREADANDMOREKptnData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);
            List<String> existingValues;
            if (yamlData.containsKey("BREADAndMoreRemoteBPKTPN")) {
                Object existingValuesObj = yamlData.get("BREADAndMoreRemoteBPKTPN");
                if (existingValuesObj instanceof List) {
                    List<String> existingValuesTyped = (List<String>) existingValuesObj;
                    existingValues = existingValuesTyped;
                } else {
                    existingValues = new ArrayList<>();
                }
            } else {
                existingValues = new ArrayList<>();
            }

            for (String value : values) {
                existingValues.add(value.replace(" ", ""));
            }

            yamlData.put("BREADAndMoreRemoteBPKTPN", existingValues);

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTotalAmountData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("totalAmount")) {
                List<String> existingValues = (List<String>) yamlData.get("totalAmount");
                existingValues.addAll(values);
            } else {
                yamlData.put("totalAmount", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeTenderAmountData(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("tenderAmount")) {
                List<String> existingValues = (List<String>) yamlData.get("tenderAmount");
                existingValues.addAll(values);
            } else {
                yamlData.put("tenderAmount", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKPPrintKTPN(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("KPReprintKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("KPReprintKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("KPReprintKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCIAPrintKTPN(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CIAReprintKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("CIAReprintKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("CIAReprintKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCIOPrintKTPN(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("CIOReprintKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("CIOReprintKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("CIOReprintKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCOPrintKTPN(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            if (yamlData.containsKey("COReprintKPTN")) {
                List<String> existingValues = (List<String>) yamlData.get("COReprintKPTN");
                existingValues.addAll(values);
            } else {
                yamlData.put("COReprintKPTN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCashIn_Kptn(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            // Check if yamlData is null or empty
            if (yamlData == null) {
                yamlData = new HashMap<>();
            }

            if (yamlData.containsKey("CashInKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CashInKTPN");
                existingValues.addAll(values);
            } else {
                yamlData.put("CashInKTPN", values);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            LoggingUtils.info(values + " saved to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeKP_Kptn(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            // Check if yamlData is null or empty
            if (yamlData == null) {
                yamlData = new HashMap<>();
            }

            if (yamlData.containsKey("KwartaPadalaKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("KwartaPadalaKTPN");
                for (String value : values) {
                    String trimmedValue = value.replace("Ref. No:", "").trim();
                    existingValues.add(trimmedValue);
                    LoggingUtils.info(trimmedValue + " saved to file"); // Update the logging statement
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    String trimmedValue = value.replace("Ref. No:", "").trim();
                    trimmedValues.add(trimmedValue);
                    LoggingUtils.info(trimmedValue + " saved to file"); // Update the logging statement
                }
                yamlData.put("KwartaPadalaKTPN", trimmedValues);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeCashOut_Kptn(List<String> values) {
        try {
            Yaml yaml = new Yaml();
            FileInputStream fileInputStream = new FileInputStream(yamlFileName);
            Map<String, Object> yamlData = yaml.load(fileInputStream);

            // Check if yamlData is null or empty
            if (yamlData == null) {
                yamlData = new HashMap<>();
            }

            if (yamlData.containsKey("CashOutKTPN")) {
                List<String> existingValues = (List<String>) yamlData.get("CashOutKTPN");
                for (String value : values) {
                    String trimmedValue = value.replace("KPTN:", "").trim();
                    existingValues.add(trimmedValue);
                    LoggingUtils.info(trimmedValue + " saved to file"); // Update the logging statement
                }
            } else {
                List<String> trimmedValues = new ArrayList<>();
                for (String value : values) {
                    String trimmedValue = value.replace("KPTN:", "").trim();
                    trimmedValues.add(trimmedValue);
                    LoggingUtils.info(trimmedValue + " saved to file"); // Update the logging statement
                }
                yamlData.put("CashOutKTPN", trimmedValues);
            }

            FileWriter writer = new FileWriter(yamlFileName);
            yaml.dump(yamlData, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void setRandomValueFromCIOA_TC_09(String randomValue) {
//        randomValueFromCIOA_TC_09 = randomValue;
//    }
//
//    public String getRandomValueFromCIOA_TC_09() {
//        return randomValueFromCIOA_TC_09;
//    }


    public String getAccessKey() {
        return (String) yamlData.get("AccessKey");
    }
}