using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class AppleTreeScript : MonoBehaviour
{
    [Header("Set in Inspector")]
    public GameObject   applePrefab;

    public float        speed = 1f;

    public float        lefTAndRightEdge = 10f;

    public float        chanceToChangeDirections = 0.1f;

    public float        secondsBetweenAppleDrops = 1f;
    void Start()
    {
        Invoke("DropApple", 2f);
    }

    void DropApple( ){
        GameObject apple = Instantiate<GameObject>(applePrefab);
        apple.transform.position = transform.position;
        Invoke("DropApple", secondsBetweenAppleDrops); 
    }
    void Update()
    {
        Vector3 pos = transform.position;
        pos.x += speed * Time.deltaTime;    //초당 이동할 거리 * 이전 프레임과 현재 프레임 사이의 시간
        transform.position = pos;
        if (pos.x < -lefTAndRightEdge){ //leftAndRightEdge에 세팅된 좌우한계점

            speed = Mathf.Abs(speed); // Mathf.Abs = 오른쪽으로 절댓값 속도 
        }
        else if (pos.x>lefTAndRightEdge)
        {
            speed = -Mathf.Abs(speed); // " = 왼쪽으로 절댓값 속도
        }
        if (pos.x < -lefTAndRightEdge ){ //pos.x가 너무 작다면 속도를 양수로 설정
                speed= Mathf.Abs (speed);
        }
        else if (pos.x > lefTAndRightEdge){ //pos.x가 너무 크다면 속도를 음수로 설정
            speed = -Mathf.Abs(speed);
        }
        else if (Random.value < chanceToChangeDirections ) {
            speed *= -1; //방향전환
            if (pos.x < -lefTAndRightEdge){
                speed = Mathf.Abs(speed);
            }
            else if(pos.x > lefTAndRightEdge){
                speed = -Mathf.Abs(speed);
            }

            void FixedUpdate() {
                if (Random.value < chanceToChangeDirections) {
                    speed *= -1;
                }
            }
        }
        }
    }

