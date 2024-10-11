using System.Collections;
using UnityEngine;

public class ArrayEx : MonoBehaviour 
{
    public string[] sArray;

    void Start () {
        sArray = new string[10];

        sArray[0] = "These";
        sArray[1] = "are";
        sArray[2] = "some";
        sArray[3] = "words";

        print("The length of sArray is: " + sArray.Length);
        
        string str = "";
        foreach (string sTemp in sArray) {
            if (!string.IsNullOrEmpty(sTemp)) {
                str += "|" + sTemp;
            }
        }
        str += "|"; // 마지막에 |를 추가합니다.
        print(str);
    }
}


