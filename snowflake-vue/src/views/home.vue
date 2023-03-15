<template>

    <el-row :gutter="20" ma>
        <el-col :span="15"><div class="grid-content bg-purple">
            <el-input type="text"  v-model="snowID" placeholder="请输入雪花ID"/>
        </div></el-col>

        <el-col :span="2"><div class="grid-content bg-purple">
            <el-button type="primary" @click="deleteID()" plain>删除雪花ID</el-button>
        </div></el-col>

        <el-col :span="2"><div class="grid-content bg-purple">
            <el-button type="success" @click="findID()" plain>查找雪花ID</el-button>
        </div></el-col>

        <el-col :span="2"><div class="grid-content bg-purple">
            <el-button type="warning" @click="createID()" plain>生成雪花ID</el-button>
        </div></el-col>
    </el-row>

    <el-table
            :data="snowData"
            border>
        <el-table-column
                fixed
                prop="id"
                label="雪花ID"
                width="300">
        </el-table-column>
        <el-table-column
                prop="timeBit"
                label="时间戳"
                width="250">
        </el-table-column>
        <el-table-column
                prop="workBit"
                label="机器码"
                width="250">
        </el-table-column>
        <el-table-column
                prop="dataBit"
                label="数据码"
                width="250">
        </el-table-column>
        <el-table-column
                prop="sequence"
                label="序列号"
                width="250">
        </el-table-column>
    </el-table>

</template>

<script>
    export default {
        name: 'home',
        data() {
            return {
                snowData: [],
                snowID:''

            }
        },
        mounted(){
            this.$http({
                method:'get',
                url:'/',//Api就是proxy中的target地址
                data:{}
            }).then(res=>{
                console.log(res)
                this.snowData=res.data;
            }).catch(err=>{
                console.log(err)
            })
        },
        methods: {

            deleteID() {
                // 获取输入框的文本内容
                const text = this.snowID;
                this.$http({
                    method:'get',
                    url:'/delete?id='+text,//Api就是proxy中的target地址
                    data:{}
                }).then(res=>{
                    console.log(res)
                    this.snowData=res.data;
                }).catch(err=>{
                    console.log(err)
                })
            },
            findID(){
                const text = this.snowID;
                this.$http({
                    method:'get',
                    url:'/search?id='+text,//Api就是proxy中的target地址
                    data:{id:text}
                }).then(res=>{
                    console.log(res)
                    this.snowData=res.data;
                }).catch(err=>{
                    console.log(err)
                })
            },
            createID(){
                const text = this.snowID;
                this.$http({
                    method:'get',
                    url:'/add',//Api就是proxy中的target地址
                    data:{}
                }).then(res=>{
                    console.log(res)
                    this.snowData=res.data;
                }).catch(err=>{
                    console.log(err)
                })
            }
        }
    }
</script>

<style scoped></style>






