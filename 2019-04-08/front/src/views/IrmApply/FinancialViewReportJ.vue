<template>
    <div class="container">
        <el-form :model="irmBaseInfo" label-width="160px" size="small">
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户编号：" prop="partyNum">
						<el-input v-model="irmBaseInfo.party.partyNum" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="客户名称：" prop="partyName">
						<el-input v-model="irmBaseInfo.party.partyName" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="客户类型：" prop="partyNum">
						<el-input v-model="irmBaseInfo.party.partyTypeCd" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="客户行业：" prop="partyName">
						<el-input v-model="irmBaseInfo.corporation.industrialTypeCd" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="银行认定企业规模：" prop="partyNum">
						<el-input v-model="irmBaseInfo.corporation.bankScaleIdentify" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="组织机构代码：" prop="partyName">
						<el-input v-model="irmBaseInfo.corporation.orgRegisterCd" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="所属机构：" prop="partyNum">
						<el-input v-model="irmBaseInfo.corporation.updateOrgNum" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="注册资本(元)：" prop="partyName">
						<el-input v-model="irmBaseInfo.corporation.registerAssets" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="职工人数(人)：" prop="partyNum">
						<el-input v-model="irmBaseInfo.corporation.employeesNumber" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="评级模型：" prop="partyName">
						<el-input v-model="irmBaseInfo.irmApply.rating_MODEL_CD" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="模型版本：" prop="partyNum">
						<el-input v-model="irmBaseInfo.irmApply.rating_MODEL_VER" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="公司成立日期：" prop="partyName">
						<el-input v-model="irmBaseInfo.corporation.registerDate" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="上次评级结果：" prop="partyNum">
						<el-input v-model="irmBaseInfo.irmApply.last_CREDIT_RATING_CD" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="11">
					<el-form-item label="上次评级有效期起：" prop="partyName">
						<el-input v-model="irmBaseInfo.irmApply.last_EFFECTIVE_START_DT" :disabled="true"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="11">
					<el-form-item label="上次评级到期日：" prop="partyNum">
						<el-input v-model="irmBaseInfo.irmApply.last_EFFECTIVE_END_DT" :disabled="true" ></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
    </div>
</template>

<script>
export default {
	name: 'FinancialViewReportJ',
	ratingApplyInfo: {},//评级申请信息
	props:{
		irmBaseInfo: {
			type: Object,
			required: true
		}
	},
    methods: {},
	mounted() {
    	//this.doInit();
	}
}
</script>
