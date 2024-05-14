package utilities.yamlReader;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import utilities.Logger.LoggingUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
    public yamlReader() {
        this.filePath = ".\\src\\test\\java\\resources\\testData.yaml";
        this.yamlFileName = this.filePath;
        yamlLoader();
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



    public String getSendOutKPTN() {
        try {
            List<String> billsPayKptn = (List<String>) yamlData.get("billsPayKTPN");

            if (billsPayKptn == null || billsPayKptn.isEmpty()) {
                System.out.println("No BillsPay KPTN values available.");
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
    public String getSendOutRemoteKPTN() {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("remoteSendoutKPTN");

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
    public String getSendOutForChange() {
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
            List<String> RemoteBillsPayKptnList = (List<String>) yamlData.get("remoteBillsPayKTPN");

            if (RemoteBillsPayKptnList == null || RemoteBillsPayKptnList.isEmpty()) {
                System.out.println("No Remote BillsPay KPTN values available.");
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

    public String getSendOutKPTN () {
        try {
            List<String> sendOutKptnList = (List<String>) yamlData.get("sendOutKPTN");

            if (sendOutKptnList == null || sendOutKptnList.isEmpty()) {
                System.out.println("No send out KPTN values available.");
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

    public String getBillsPayAmount() {
        try {
            List<Integer> amountList = (List<Integer>) yamlData.get("BillsPayAmount");

            if (amountList == null || amountList.isEmpty()) {
                System.out.println("No Amount values available.");
                return null;
            }

            int randomIndex = new Random().nextInt(amountList.size());
            Integer randomAmount = amountList.get(randomIndex);
            amountList.remove(randomIndex);
            saveYamlData();
            return randomAmount.toString();

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
    public String getSuccessPayoutKPTN () {
        try {
            List<String> kptnList = (List<String>) yamlData.get("payoutKPTN");

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
    public String getSuccessRemotePayoutKPTN () {
        try {
            List<String> kptnList = (List<String>) yamlData.get("remotePayoutKPTN");

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
    public String getRemotePayoutKPTN () {
        try {
            List<String> kptnList = (List<String>) yamlData.get("remotePayoutKPTN");

            if (kptnList == null || kptnList.isEmpty()) {
                System.out.println("No payoutKPTN values available.");
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
    public String getRemoteKPTN () {
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
    public String getRandomCashOutReferenceNum () {
        try {
            List<String> cashOutReferenceNumList = (List<String>) yamlData.get("CashOutKTPN");
            if (cashOutReferenceNumList == null || cashOutReferenceNumList.isEmpty()) {
                System.out.println("No Random Cash Out Reference Number available.");
                return null;
            }
            int randomIndex = new Random().nextInt(cashOutReferenceNumList.size());
            String randomCashOutReferenceNum = cashOutReferenceNumList.get(randomIndex);
            cashOutReferenceNumList.remove(randomIndex);
            saveYamlData();
            return randomCashOutReferenceNum;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getRandomKPPReferenceNum () {
        try {
            List<String> kppReferenceNumList = (List<String>) yamlData.get("KwartaPadalaKTPN");
            if (kppReferenceNumList == null || kppReferenceNumList.isEmpty()) {
                System.out.println("No KPPP Reference Number available.");
                return null;
            }
            int randomIndex = new Random().nextInt(kppReferenceNumList.size());
            String randomKPPReferenceNum = kppReferenceNumList.get(randomIndex);
            kppReferenceNumList.remove(randomIndex);
            saveYamlData();
            return randomKPPReferenceNum;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCIAReprintKPTN () {
        try {
            List<String> CIAKptnList = (List<String>) yamlData.get("CIAReprintKPTN");

            if (CIAKptnList == null || CIAKptnList.isEmpty()) {
                System.out.println("No send out KPTN values available.");
                return null;
            }


            int randomIndex = new Random().nextInt(CIAKptnList.size());
            String randomSendOutKptn = CIAKptnList.get(randomIndex); //Randomly selected send out KPTN directly from the list
            CIAKptnList.remove(randomIndex);
            saveYamlData();
            return randomSendOutKptn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getKPReprintKPTN () {
        try {
            List<String> KPKptnList = (List<String>) yamlData.get("KPReprintKPTN");

            if (KPKptnList == null || KPKptnList.isEmpty()) {
                System.out.println("No KP KPTN values available.");
                return null;
            }


            int randomIndex = new Random().nextInt(KPKptnList.size());
            String randomKPKPTN = KPKptnList.get(randomIndex);
            KPKptnList.remove(randomIndex);
            saveYamlData();
            return randomKPKPTN;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void saveYamlData () {
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
    public void writePayoutKptnData (List < String > values) {
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

    public void writeRemotePayoutKptnData (List < String > values) {
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
    public void writeBillsPayKptnData (List < String > values) {
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
    public void writeRemoteBillsPayKptnData (List < String > values) {
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
    public void writeTotalAmountData (List < String > values) {
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
    public void writeTenderAmountData (List < String > values) {
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
    public void writeKPPrintKTPN (List < String > values) {
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
    public void writeCIAPrintKTPN (List < String > values) {
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

    public void writeKP_Kptn (List < String > values) {
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
    public void writeCashOut_Kptn (List < String > values) {
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

    public void writeCashIn_Kptn (List < String > values) {
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


    public String getRandomWriteCashIn_Kptn () {
        try {
            List<String> referenceNumList = (List<String>) yamlData.get("CashInKTPN");
            if (referenceNumList == null || referenceNumList.isEmpty()) {
                System.out.println("No Cash In KPTN available.");
                return null;
            }
            int randomIndex = new Random().nextInt(referenceNumList.size());
            String randomWriteCashIn_Kptn = referenceNumList.get(randomIndex);
            referenceNumList.remove(randomIndex);
            saveYamlData();
            return randomWriteCashIn_Kptn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }



        public void setRandomValueFromCIOA_TC_09(String randomValue) {
            randomValueFromCIOA_TC_09 = randomValue;
        }

        public String getRandomValueFromCIOA_TC_09() {
            return randomValueFromCIOA_TC_09;
        }


    public String getAccessKey () {
        return (String) yamlData.get("AccessKey");
    }
}