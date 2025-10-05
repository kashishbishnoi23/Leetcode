class Solution {

    private boolean isValidIPV4(String str){
        if (str.length() > 1 && str.startsWith("0")) return false;

        // can be converted to integer:
        boolean isInteger = true;
        int number = -1;

        try{
            number = Integer.parseInt(str);
        } catch(NumberFormatException e){
            isInteger = false;
        }
        System.out.println(number);
        if (isInteger && number >= 0 && number <= 255) return true;

        return false;
    }

    private boolean isValidIPV6(String str){
        if (str.isEmpty()) return false;
        if (str.length() > 4) return false;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'f' || ch >= 'A' && ch <= 'F'){
                continue;
            }
            return false;
        } 
        return true;
    }
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') != -1){
            // check for IPV4
            if (queryIP.endsWith(".")) return "Neither";
            String [] parts = queryIP.split("\\.");
            System.out.println(parts.length);
            if (parts.length != 4) return "Neither";
           
            for (int i = 0; i < parts.length; i++){
                if (!isValidIPV4(parts[i])) return "Neither";
            }
            return "IPv4";
        } else if (queryIP.indexOf(':') != -1){
            // check for IPV6

            if (queryIP.endsWith(":")) return "Neither";

            String[] parts = queryIP.split(":");
            if (parts.length  != 8) return "Neither";

            for (int j = 0; j < parts.length; j++){
                if (!isValidIPV6(parts[j])) return "Neither";
            }

            return "IPv6";
        }

        return "Neither";
    }
}