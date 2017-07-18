
/**
 * Creates a list of contacts and uses methods to search them
 * @author Lars Beutlich 
 * @version 5/2/2017
 */
public class TestContact
{
    //Prints out the contact list 
    public static void printContacts(Contact[] myContacts)
    {
        for (Contact contact : myContacts)
        {
            System.out.println(contact); 
        }
    }
    
    //Performs a selection sort to sort the list of contacts in ascending order based on their name
    public static void sortName(Contact[] myContacts)
    {
        for (int i = myContacts.length - 1; i > 0; i--)
        {
            //Finds the index of the largest name in the current array 
            int largestIndex = 0; 
            for (int j = 1; j <= i; j++)
            {
                if (myContacts[j].getName().compareTo(myContacts[largestIndex].getName()) > 0)
                {
                    largestIndex = j; 
                }
            }
            
            //Puts the largest name in the rightmost position of the current array 
            Contact temp = myContacts[i]; 
            myContacts[i] = myContacts[largestIndex]; 
            myContacts[largestIndex] = temp; 
        }
    }
    
    //Performs a binary search to find a specified name in the contact list 
    public static int findByName(Contact[] myContact, String name)
    {
        int high = myContact.length; 
        int low = -1; 
        int mid; 
        
        //Continuosly breaks the array in half until the specified name is found, if present 
        while(high - low > 1)
        {
            mid = (high + low) / 2; 
            
            if(myContact[mid].getName().compareTo(name) > 0)
            {
                high = mid; 
            } else 
            {
                low = mid; 
            }
        }
        
        //Returns the index of name that was searched if it was found 
        if ((low >= 0) && (myContact[low].getName().equals(name)))
        {
            return low; 
        } else 
        {
            return -1;
        }
    }
    
    //Uses a sequential search to find all instances of a contact with a specified relationship
    public static void findByRelation(Contact[] myContact, String relation)
    {
        int found = 0; 
        for (int i = 0; i < myContact.length; i++)
        {
            if (myContact[i].getRelation().equals(relation))
            {
                System.out.println(myContact[i]); 
                found++; 
            }
        }
        
        //Prints out how many instaces were found 
        if (found > 0)
        {
            System.out.println("Found " + found + " instances of contacts that have the relation: " + relation); 
        } else 
        {
            System.out.println("Could not find any contacts with the relation: " + relation);
        }
    }
    
    //Uses a sequential search to find all instaces of a contact with the specified birthday at a given month
    public static void findByBMonth(Contact[] myContact, String month)
    {
        int found = 0; 
        for (int i = 0; i < myContact.length; i++)
        {
            if (myContact[i].getBday().substring(0, 3).equals(month))
            {
                System.out.println(myContact[i]); 
                found ++; 
            }
        }
        
        //Prints out how many instances were found 
        if (found > 0)
        {
            System.out.println("Found " + found + " instances of contacts that have a birthday in month: " + month); 
        } else 
        {
            System.out.println("Could not find any contacts with a birthay in month: " + month); 
        }
    }
    
    //Uses a sequential search to find all instances of a contact with the specified phone number 
    public static void findByPhone(Contact[] myContact, String number)
    {
        int found = 0; 
        for (int i = 0; i < myContact.length; i++)
        {
            if (myContact[i].getPhone().equals(number))
            {
                System.out.println(myContact[i]); 
                found++; 
            } 
        }
        
        //Prints out how many instances were found 
        if (found > 0)
        {
            System.out.println("Found " + found + " instances of contacts with the phone number: " + number); 
        } else 
        {
            System.out.println("Could not find any instaces with the phone number: " + number); 
        }
    }
    
    //Uses a merge sort to sort the contact list by emails to prepare for a binary search 
    public static void mergeSortEmail(Contact[] myContact, int low, int high)
    {
        //Checks to see if the list is a single item 
        if (low == high)
        {
            return;
        }
        
        //Creates a recursive call to the mergeSort method to break the list into smaller units, then returns them sorted 
        int mid = (low + high) / 2; 
        
        mergeSortEmail(myContact, low, mid);
        mergeSortEmail(myContact, mid+1, high); 
        
        mergeEmail(myContact, low, mid, high); 
    }
    
    //An algorithm to merge together two lists into one larger sorted list 
    public static void mergeEmail(Contact[] myContact, int low, int mid, int high)
    {
        Contact[] temp = new Contact[high - low + 1];
        
        int leftIndex = low; 
        int rightIndex = mid + 1;
        int tempIndex = 0; 
        
        //Puts the two lists into sorted order in the temp array 
        while(leftIndex <= mid || rightIndex <= high)
        {
            if(leftIndex > mid)
            {
                temp[tempIndex] = myContact[rightIndex]; 
                rightIndex ++; 
            } else if (rightIndex > high)
            {
                temp[tempIndex] = myContact[leftIndex]; 
                leftIndex++; 
            } else if (myContact[leftIndex].getEmail().compareTo(myContact[rightIndex].getEmail()) < 0)
            {
                temp[tempIndex] = myContact[leftIndex]; 
                leftIndex++; 
            } else 
            {
                temp[tempIndex] = myContact[rightIndex];
                rightIndex++; 
            }
            tempIndex++; 
        }
        
        //Puts the temp index back into the real array 
        for (int i = low; i <= high; i++)
        {
            myContact[i] = temp[i - low];  
        }
    }
    
    //An algorithm to perform a binary search for a specified email 
    public static int findByEmail(Contact[] myContact, String email)
    {
        //Breaks down the array into smaller arrays until one item is left, hopefully the item we are searching for 
        int low = -1; 
        int high = myContact.length; 
        int mid; 
        
        while (high - low > 1)
        {
            mid = (high + low) / 2; 
            
            if(myContact[mid].getEmail().compareTo(email) > 0)
            {
                high = mid;
            } else 
            {
                low = mid;
            }
        }
        
        //Returns the index of the searched for item if it is found 
        if((low >= 0) && (myContact[low].getEmail().equals(email)))
        {
            return low; 
        } else 
        {
            return -1; 
        }
    }
    
    public static void main(String[] args)
    {
        Contact[] myContacts = new Contact[6]; 
        myContacts[0] = new Contact("John Carter", "brother", "Mar 3", "(342)555-7069", "jcarter@carter.com"); 
        myContacts[1] = new Contact("Elise Carter", "mother", "Apr 19", "(342)555-7011", "carterMom@carter.com");
        myContacts[2] = new Contact("Ellie Carter", "me", "Jun 10", "(342)555-8102", "ecarter@carter.com");
        myContacts[3] = new Contact("Sue Ellen", "friend", "Mar 9", "(342)555-9182", "susieE@hotmail.com");
        myContacts[4] = new Contact("Frank Carter", "dad", "Dec 1", "(342)555-7011", "carterDad@carter.com");
        myContacts[5] = new Contact("Johnnie", "friend", "Jan 21", "(342)555-7789", "jDawg5555@yahoo.com");
        
        //Output 
        System.out.println("Contact List: "); 
        printContacts(myContacts); 
        System.out.println(); 
        System.out.println();
        
        //Search for a name in the contact list using binary search 
        //Sort the contact list to allow for the binary search to ocurr
        sortName(myContacts); 
        
        //Perform the binary searches 
        int index = findByName(myContacts, "Johnnie"); 
        System.out.println("Searching for: Name - Johnnie");
        if (index >= 0)
        {
            System.out.println(myContacts[index]); 
        } else 
        {
            System.out.println("Could not find Johnnie in the array"); 
        }
        System.out.println(); 
        
        index = findByName(myContacts, "Sam Parker"); 
        System.out.println("Searching for: Name - Sam Parker");
        if (index >= 0)
        {
            System.out.println(myContacts[index]); 
        } else 
        {
            System.out.println("Could not find Sam Parker in the array"); 
        }
        System.out.println(); 
        System.out.println(); 
        
        //Search for a certain relation in the contact list using a sequential search 
        System.out.println("Find Relation - friend"); 
        findByRelation(myContacts, "friend"); 
        System.out.println();
        
        System.out.println("Find Relation - Aunt"); 
        findByRelation(myContacts, "Aunt"); 
        System.out.println();
        System.out.println(); 
        
        //Search for a certain month in the contact list using a sequential search 
        System.out.println("Find Bday - May"); 
        findByBMonth(myContacts, "May"); 
        System.out.println();
        
        System.out.println("Find Bday - Mar"); 
        findByBMonth(myContacts, "Mar"); 
        System.out.println();
        System.out.println(); 
        
        //Search for a certain phone number in the contact list using a sequential search 
        System.out.println("Find phone - (333)555-8989"); 
        findByPhone(myContacts, "(333)555-8989"); 
        System.out.println();
        
        System.out.println("Find phone - (342)555-7011"); 
        findByPhone(myContacts, "(342)555-7011"); 
        System.out.println();
        System.out.println(); 
        
        //Searches for a certain email in the contact list using a binary search 
        mergeSortEmail(myContacts, 0, 5); 
        
        index = findByEmail(myContacts, "rgoodman@hotmail.com"); 
        System.out.println("Searching for: email - rgoodman@hotmail.com");
        if (index >= 0)
        {
            System.out.println(myContacts[index]); 
        } else 
        {
            System.out.println("Could not find rgoodman@hotmail.com in the array"); 
        }
        System.out.println(); 
        
        index = findByEmail(myContacts, "susieE@hotmail.com"); 
        System.out.println("Searching for: email - susieE@hotmail.com");
        if (index >= 0)
        {
            System.out.println(myContacts[index]); 
        } else 
        {
            System.out.println("Could not find susieE@hotmail.com in the array"); 
        }
        System.out.println(); 
        System.out.println(); 
    }
}
