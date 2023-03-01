package utils;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class PropertiesFile {
    FileInputStream fis = null;
    Properties prop = null;


    public Properties PropertyFileReader(String FileName) {

        try {
            fis = new FileInputStream(FileName);
            prop = new Properties();
            try {
                prop.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return prop;
    }

    public static void val() throws IOException, InterruptedException {
//        MultiMap multiMap = new MultiValueMap();
//        // put values into map for A
//        multiMap.put("A", "Apple");
//        multiMap.put("A", "Aeroplane");
//
//        // put values into map for B
//        multiMap.put("B", "Bat");
//        multiMap.put("B", "Banana");
//
//        // put values into map for C
//        multiMap.put("C", "Cat");
//        multiMap.put("C", "Car");
//
//        // retrieve and display values
//        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
//        Set<String> keys = multiMap.keySet();
//        for (String key : keys) {
//          //  System.out.println("Key = " + key);
//            System.out.println("Values = " + multiMap.get(key) + "n");
//        }
//        System.out.println(DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH));
//        Calendar cal = Calendar.getInstance();
//        Date today = cal.getTime();
//        int date = cal.get(Calendar.DATE);
//        System.out.println(date);
//        String url="https://ri-leasingdeskadmin-uat.realpage.com/Resident/PolicyDetails/88605978/11471728?srch_term=110016049";
//        String[] splittedArray=url.split("/|\\?|\\=");
//        System.out.println(splittedArray);
//        final String s = splittedArray[splittedArray.length - 2];
//        System.out.println(s);
//        Faker fs=new Faker();
//       String zs= fs.address().zipCode();
//        System.out.println(zs);
//       String ne= zs.replaceAll("-[0-9]*","");
//        String ne= zs.replaceAll("(?<=^[0-9]{4})(-)(?=$)","");
//        System.out.println(ne);
//      System.out.println(fs.address().zipCode());
//        int[] arr = {19, 20, 17, 200, 13};
//       for(int i=1;i< arr.length;i=i+2)
//        System.out.println(arr[i]);
//        ArrayList<Integer> num = new ArrayList<>();
//        num.add(1);
//        num.add(2);
//        num.add(4);
//        num.add(4);
//        List<Integer> ne = num.stream().distinct().collect(Collectors.toList());
//        Set<Integer> nes = new HashSet<>(num);
//        System.out.println(nes);

//        int num1 = 0;
//        int num2 = 1;
//        int sum;
//        for (int i = 0; i <= 10; i++) {
//            sum = num1 + num2;
//            num1 = num2;
//            num2 = sum;
//            System.out.println(num1);
//
//
//        }


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",
                System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
        System.setProperty("webdriver.chrome.driver", "..\\cucumber\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver;
//       System.out.println(options.getExperimentalOption("prefs"));
//
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        // Alert Message handling
//      driver.get("https://demo.guru99.com/test/delete_customer.php");
//
//       driver.findElement(By.name("cusid")).sendKeys("53920");
//        driver.findElement(By.name("submit")).submit();
//        // Switching to Alert
//        Alert alert = driver.switchTo().alert();
//        // Capturing alert message.
//        String alertMessage= driver.switchTo().alert().getText();
//        // Displaying alert message
//        System.out.println(alertMessage);
//        Thread.sleep(5000);
//        // Accepting alert
//        alert.sendKeys("remvor");
//        alert.accept();
        //windows
//
//        driver.get("https://demo.guru99.com/popup.php");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
//
//        String MainWindow = driver.getWindowHandle();
//
//        // To handle all new opened window.
//        Set<String> s1 = driver.getWindowHandles();
//        Iterator<String> i1 = s1.iterator();
//
//        while (i1.hasNext()) {
//            String ChildWindow = i1.next();
//
//            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
//
//                // Switching to Child window
//                driver.switchTo().window(ChildWindow);
//                driver.findElement(By.name("emailid"))
//                        .sendKeys("gaurav.3n@gmail.com");
//
//                driver.findElement(By.name("btnLogin")).click();
//
//                // Closing the Child Window.
//                driver.close();
//            }
//        }
//        // Switching to Parent window i.e Main Window.
//        driver.switchTo().window(MainWindow);

        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("iframe1");
        WebElement text=driver.findElement(By.xpath("(//h1[@id='sampleHeading'])[1]"));
        System.out.println(text);

      //  driver.switchTo().frame("iframe1");
        driver.quit();

//        WebElement iframeElement = driver.findElement(By.id("IF1"));
//
//        //now use the switch command
//        driver.switchTo().frame(0);
//
//        //Do all the required tasks in the frame 0
//        //Switch back to the main window
//        driver.switchTo().defaultContent();
//        driver.quit();
        //  driver=new ChromeDriver();
//        System.out.println("Tests Running browser is:");
//        driver.get("https://ri-leasingdeskadmin-qa4.realpage.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
//        WebElement userName = driver.findElement(By.xpath("//input[@id='Login']"));
//        userName.sendKeys("ldadmin@leasingdesk.com");
//        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
//        password.sendKeys("1234567");
//        WebElement login = driver.findElement(By.xpath("//input[@value='LOG IN']"));
//        login.click();
//        Thread.sleep(1000);
//        WebElement property = driver.findElement(By.xpath("//a[text()=' Property Search ']"));
//        property.click();
//        Thread.sleep(200);
//        WebElement BulkCds = driver.findElement(By.xpath("//a[contains(text(),'Bulk CDS')]"));
//        BulkCds.click();
//        Thread.sleep(20000);
////        WebElement editProperty = driver.findElement(By.xpath("//a[contains(text(),'Sample template to EDIT property')]"));
////        editProperty.click();
//        WebElement choseFile = driver.findElement(By.xpath("//input[@id='formFile']"));
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", choseFile);
////        choseFile.click();
//        choseFile.sendKeys("C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx");
//        Thread.sleep(5000);
//        WebElement uploadCds = driver.findElement(By.xpath("//button[contains(text(),'Upload CDS')]"));
//        js.executeScript("arguments[0].click();", uploadCds);
//        String excelPath = "C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx";
//        System.out.println(excelPath);
//        XSSFWorkbook workBook = new XSSFWorkbook(excelPath);
//        int sheets = workBook.getNumberOfSheets();
//        for (int i = 0; i < sheets; i++) {
//            if (workBook.getSheetName(i).equalsIgnoreCase("Bulk Property settings")) {
//                XSSFSheet sheet = workBook.getSheetAt(i);
//                Iterator<Row> rows = sheet.iterator();
//                Row firstRow = rows.next();
//                Iterator<Cell> c = firstRow.cellIterator();
//                int k = 0;
//                while (c.hasNext()) {
//                    Cell cellValue = c.next();
//                    System.out.println(cellValue.getStringCellValue());
//                    if (cellValue.getStringCellValue().equalsIgnoreCase("PropertyID")) {
//                        System.out.println(cellValue.getStringCellValue());
//                    }
//                    k++;
//                }
//            }
//
//        }


//
//        driver.get("https://www.browserstack.com/test-on-the-right-mobile-devices");
//        WebElement downloadCss = driver.findElement(By.xpath("//a[@class='icon-csv']"));
//        driver.findElement(By.id("accept-cookie-notification")).click();
//        downloadCss.click();
//        System.out.println(ne);
//        driver.get("https://google.com/ncr");
//        driver.navigate().
//        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
//        driver.findElement(By.name("q")).click();
//// Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10000))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
//// Print the first result
//        System.out.println(firstResult.getText());

    }

    public static void deleteFile() {
        String fileName = System.getProperty("user.dir") + "\\" + "externalFiles";
        System.out.println(fileName);
        try {
            boolean result = Files.deleteIfExists(Paths.get(fileName));
            if (result) {
                System.out.println("File is deleted!");
            } else {
                System.out.println("Sorry, unable to delete the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String randomAlphaNumericGenerator() {
        //        String numeric=RandomStringUtils.randomNumeric(10);
//        String alphabet=RandomStringUtils.randomAlphabetic(7);
        return RandomStringUtils.randomAlphanumeric(10);


        //   System.out.println(random);
//        System.out.println(numeric);
//        System.out.println(alphabet);

    }

    public static void verifyAlphaNumeric() {
        String name = "1234567890nfskksryteu";
        if (name.contains(randomAlphaNumericGenerator())) System.out.println("values matched");
        else {
            throw new IllegalArgumentException("Values not matched");
        }
    }

    public static void encodeFileToBase64Binary() throws IOException {

//        File originalFile = new File("C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx");
//        String encodedBase64 = null;
//        try {
//            FileInputStream fileInputStreamReader = new FileInputStream(originalFile);
//            byte[] bytes = new byte[(int)originalFile.length()];
//            fileInputStreamReader.read(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] bytes = Base64.getEncoder().encode(Files.readAllBytes(new File("C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx").toPath()));
//        System.out.print(bytes);
//        Base64.Encoder encoder = Base64.getMimeEncoder();
//        String normalString = "C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx";
//
//        String encodedString = encoder.encodeToString(
//                normalString.getBytes(StandardCharsets.UTF_16BE) );
//        System.out.println(encodedString);
//        return encodedString;
//        String inputfile="C:\\Users\\lginne\\IdeaProjects\\cucumber\\externalFiles\\downloadFiles\\BulkCDS-Edit.xlsx";
//        byte[] input_file = Files.readAllBytes(Paths.get(inputfile));
//        byte[] encodedBytes = Base64.getEncoder().encode(input_file);
//        String encodedString =  new String(encodedBytes);
//        System.out.println(encodedString);
//        return encodedString;
        System.out.println(System.getProperty("user.dir") + "\\" + "externalFiles" + "\\" + "downloadFiles" + "BulkCDS-Edit.xlsx");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        val();
//        deleteFile();
//        randomAlphaNumericGenerator();
        //   verifyAlphaNumeric();
//        encodeFileToBase64Binary();

    }
}
