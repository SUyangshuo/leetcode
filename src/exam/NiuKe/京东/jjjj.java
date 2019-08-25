package exam.NiuKe.京东;

import java.util.List;

public class jjjj {
    public void FillBoomList(Item current) {
        //计数器
        int rowCount = 0;
        int columnCount = 0;
        //临时列表
        List rowTempList = new List ();
        List columnTempList = new List ();
        //横向纵向检测
        foreach (var item in sameItemsList)
        {
            //如果在同一行
            if (item.itemRow == current.itemRow)
            {
                //判断该点与Curren中间有无间隙
                bool rowCanBoom = CheckItemsInterval(true,current,item);
                if (rowCanBoom)
                {
                    //计数
                    rowCount++;
                    //添加到行临时列表
                    rowTempList.Add (item);
                }
            }
            //如果在同一列
            if (item.itemColumn == current.itemColumn)
            {
                //判断该点与Curren中间有无间隙
                bool columnCanBoom = CheckItemsInterval(false,current,item);
                if (columnCanBoom)
                {
                    //计数
                    columnCount++;
                    //添加到列临时列表
                    columnTempList.Add (item);
                }
            }
        }
        //横向消除
        bool horizontalBoom = false;
        //如果横向三个以上
        if (rowCount > 2)
        {
            //将临时列表中的Item全部放入BoomList
            boomList.AddRange (rowTempList);
            //横向消除
            horizontalBoom = true;
        }
        //如果纵向三个以上
        if (columnCount > 2)
        {
            if (horizontalBoom)
            {
                //剔除自己
                boomList.Remove (current);
            }
            //将临时列表中的Item全部放入BoomList
            boomList.AddRange (columnTempList);
        }
        //如果没有消除对象，返回
        if (boomList.Count == 0)
        {
            return;
        }
        //创建临时的BoomList
        List tempBoomList = new List ();
        //转移到临时列表
        tempBoomList.AddRange (boomList);
        //开启处理BoomList的协程
        StartCoroutine (ManipulateBoomList (tempBoomList));
    }
}
