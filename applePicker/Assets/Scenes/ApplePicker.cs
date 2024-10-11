using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ApplePicker : MonoBehaviour
{
    [Header("Set in Inspector")]
    public GameObject basketPrefab;
    public int numBaskets = 3;
    public float basketBottomY = -14f;
    public float basketSpacingY = 2f;

    // 바구니 게임 오브젝트들을 관리할 리스트
    private List<GameObject> basketList;

    void Start()
    {
        basketList = new List<GameObject>();

        for (int i = 0; i < numBaskets; i++)
        {
            GameObject tBasketGO = Instantiate<GameObject>(basketPrefab);
            Vector3 pos = Vector3.zero;
            pos.y = basketBottomY + (basketSpacingY * i);
            tBasketGO.transform.position = pos;

            // 리스트에 바구니 추가
            basketList.Add(tBasketGO);
        }
    }

    public void AppleDestroyed()
    {
        // 바구니가 비어있지 않은지 확인
        if (basketList.Count > 0)
        {
            // 마지막 바구니 제거
            GameObject tBasketGO = basketList[basketList.Count - 1];
            basketList.RemoveAt(basketList.Count - 1);
            Destroy(tBasketGO);
        }

        // 바구니가 모두 제거되면 씬을 다시 로드
        if (basketList.Count == 0)
        {
            SceneManager.LoadScene("SampleScene");
        }
    }
}
