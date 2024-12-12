package io.parity.signer.components.documents

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.parity.signer.R
import io.parity.signer.components.base.MarkdownText
import io.parity.signer.components.base.ScreenHeader
import io.parity.signer.components.base.toRichTextStr
import io.parity.signer.domain.Callback
import io.parity.signer.ui.theme.SignerNewTheme

/**
 * Terms and conditions content.
 */

@Composable
fun TosScreen(onBack: Callback) {
	Column(
		Modifier
			.verticalScroll(rememberScrollState())
	) {
		ScreenHeader(
			title = stringResource(R.string.documents_terms_of_service),
			onBack = onBack
		)
		TosText(modifier = Modifier.padding(16.dp))
	}

	BackHandler(onBack = onBack)
}


@Composable
fun TosText(modifier: Modifier = Modifier) {
	MarkdownText(
		modifier = modifier,
		content =
		"""
**TERMS AND CONDITIONS**

Effective Date: 4 September 2024

Welcome to website and mobile application (hereinafter jointly, the “**App**”)! This App is operated by Trait Tech as defined below (“**Trait Tech**”). These Terms and Conditions is the binding legal agreement between Trait Tech and you, the user of our App, and Services as defined below.

The following Terms & Conditions govern your access and use of the App and the Services.

Any purchase and use of Trait Token created and distributed by Trait Token is defined by the relevant Terms and Conditions as amended from time to time. Such Terms and Conditions shall be legally binding on you.

**By visiting our App, and/or purchasing our Services, you constitute an agreement to these Terms. If you do not agree to be bound by these Terms, you shall not access this App or use our Services. Please read these Terms before you use this App, and Services.**

Trait Tech reserves the right, at its sole discretion, to change these Terms. These changes are effective immediately upon posting the amended Terms on the App, unless otherwise stated. When changes come into effect, the revised Terms shall supersede the previous version of the Terms. You are responsible for regularly reviewing these Terms. 

1. **Definitions**

   1. “**Trait Tech**” means an Exempt Private Company Limited by Shares, duly incorporated in Singapore, having its registered address at 10 Anson Road, #20-05, International Plaza, Singapore (079903).
   2. “**Trait Token**” means tokens issued by Trait Tech.
   3. “**Services**” means Trait Tech’s services on maintaining and hosting the App and Software, making available services accessible through it.
   4. “**Terms**” means these Terms and Conditions as amended from time to time.
   5. “**User**” means any entity accessing or using the Service and App.

2. **Disclaimer**

   1. The App and Services do not constitute the provision of any financial or investment advice in connection with the Services contemplated by these Terms. The information and materials contained on the App is given for information purpose only and is not to be construed as a solicitation to enter into any transaction. You should consult a financial or investment professional regarding any possible transaction if you have any doubts.
   2. The detailed disclaimer is provided in the Terms governing the purchase and use of Trait Tokens.
   3. You should carefully consider all possible risks, and you shall be free to make your own decision 

3. **Eligibility**

   1. By using the Services, you represent and warrant that you have not previously been suspended or removed from the App.

4. **Restricted Countries**

   1. You should be aware that our App may be restricted and/or unavailable for users in some jurisdictions as governed by applicable laws. Trait Tech shall not be responsible for any unavailability of our App and/or Services in any Restricted Country or other countries. 
   2. You should personally ensure that using our Services is allowed in your country of citizenship or residence. Trait Tech shall not be responsible for any violation of laws pertaining to the above.
   3. Trait Tech shall not be held liable for any use of our Services by individuals or legal entities that are restricted or limited to use our Services. Users who violate their applicable laws and regulations shall be solely liable for such violation.

5. **Use Restrictions**

   1. When accessing to and using the Services, the User shall not:

1) Copy, duplicate, reproduce or publish the Services or any of their contents;

2. Electronically transfer the Services to multiple computers over a network;

3) Distribute copies of the Services to others by any means whatsoever;

4. In whole or in part change, modify, adapt, translate, reverse engineer, disassemble or decompile the Services or create derivative works based on the Services;

5) Assign, rent, exchange, hire out, lend, lease or sublease the Services or any copies thereof;

6. Sell or transfer the Services or any copies thereof;

7) Bundle, repackage, or include the Services with any software in any way;

8) Use the Services beyond the term of a free trial subscription, if applicable;

8. Utilize the Services for any purpose or project other than the permitted use(s) as set in these Terms.

2) Unless otherwise indicated under the Clause 5.1 above, all intellectual property rights (such as but not limited to trademarks, trade names, logos, patents, copyrights, domain names and derivative rights) in the Services and related content and technology around the world are and will remain the exclusive property of Trait Tech or its licensors. 
3) The User shall be solely responsible for saving all User data as such data will be deleted any time after the subscription is terminated for any reason.

6. **Wallet**

   1. Trait Tech provides a non-custodial wallet software for digital assets issued on TRAIT blockchain. The Users can use the wallet to authorize transactions and pay for the Services. The Users shall be solely responsible for:

- any activities and risks associated with their wallet;
- retention and security of their private key to access the wallet.

2. Keeping your private key securely is important, otherwise you may lose control of your wallet. Trait Tech does not store or have access to your private key and cannot retrieve it in case of loss. The private keys are stored at User’s device only. Trait Tech shall have no responsibility or liability whatsoever in the event you are unable to access your wallet for any reason or lose your tokens. The User shall be solely responsible for saving backup keys, and use the App at its sole risk. 
3. The User is solely liable for determining whether any taxes apply to the transactions the User performs with the wallet. You agree that we are not responsible for determining whether taxes apply to your transactions or for collecting, reporting, withholding, or remitting any taxes.

7) **Use of the Services**

   1. Certain Services and access to the App may only be accessible subject to the following conditions:

1. You ensure that using our Services is allowed in your country of citizenship or residence.

2. You must comply with these Terms.

3. You agree to comply with any and all laws, regulations, and rules of governmental or regulatory authorities applicable to you and our Services. 

8) **Use of the App**

   1. You agree that you will not use the Services for any purpose that is unlawful or prohibited by these Terms. You must not, without limitation:

1. use our Services to perform criminal activity of any kind, including but not limited to, money laundering, illegal gambling, terrorist financing or malicious hacking;

2. damage, disable, overburden or impair the App or Services, or interfere with any other party’s use and enjoyment of the App or Services;

3. attempt to gain unauthorised access to the Services, computer systems or networks connected to the Services by any means;

4. reproduce, duplicate, copy, sell, resell or exploit any portion of the Service, use of the Service, or access to the Service without the express written permission by Trait Tech;

5. upload, post, host, or transmit unsolicited email, SMSs, or “spam” messages;

6. make available any materials containing viruses, bots or other code, files or programs designed to interfere, hinder or impair the operation of any computer, telecommunication equipment or software;

7. violate third party rights, including, without limitation, Trait Tech’s agents, partners, on the App and/or cause harm in any way;

8. collect and store personal information of other users without their proper authorization.

9) **Fraud Attempts; Access Restrictions**

   1. If we have reasons to believe that your use of this App and Services is fraudulent and/or illegal, we are entitled in our sole discretion to block, suspend or terminate your access to the App or deny the use of any Services. If you have conducted any fraudulent and/or illegal activity, Trait Tech reserves the right to take any necessary legal action, and you may be liable for monetary losses to Trait Tech.

10) **Intellectual Property Rights**

    1. The intellectual property contained in the App, and Services (and any derivative works based on them) is confidential and/or proprietary information of Trait Tech, our affiliates or its licensors and is protected by copyright and other intellectual property rights. All title, ownership and intellectual property rights on the App, and Services shall remain with Trait Tech, our affiliates or licensors, as the case may be. All rights not otherwise claimed under the Terms or by Trait Tech are hereby reserved.
    2. You further acknowledge and agree that the App, and Services are protected by copyrights, trademarks (whether registered or being under registration), service marks, patents or other proprietary rights and laws. Except as expressly permitted by applicable law or as authorized by Trait Tech or the applicable licensor (such as an advertiser), you agree not to modify, rent, lease, loan, sell, distribute, transmit, broadcast, publicly perform or create derivative works based on the Services, or the App, in whole or in part. Without limiting the foregoing, any reproduction, redistribution, reverse engineering or decompilation of the Services, or the App is expressly prohibited by law, and may result in severe civil and criminal penalties. 

11) **Linked Sites**

    1. This App may contain links to third party web sites (“linked sites”). The linked sites are not under the control of Trait Tech and we are not responsible for the content of any linked site. Trait Tech makes no representations regarding the content or appropriateness of content on such sites. When you access a linked site from this App, you leave this App and you do so at your own risk. You are responsible for viewing and complying with the terms and conditions posted on the linked site. 

12) **Disclaimer of Warranties**

    1. All Services, including software, products, information, text, and related graphics contained within or available through the App are provided “as is” and “as available”. Under no circumstances shall we be liable for any errors or omissions in the Services on the App. Trait Tech makes no representations or warranties of any kind, either express or implied, as to the operation of this App or the Services, data or materials included on this App. Trait Tech does not warrant or make any representations regarding suitability, availability, accuracy, reliability, completeness, or timeliness of any material of any kind contained within the Services. We cannot ensure that the Services and other information provided on the App are accurate, correct, reliable, exhaustive, or complete on every subject. 
    2. Under no circumstances shall Trait Tech, including its subsidiaries, affiliates, officers, agents, licensors, employees, partners, licensors, or others involved in creating, sponsoring, promoting or otherwise making available the App and its content, be liable to any person or entity whatsoever for any direct, indirect, incidental, consequential or punitive damages or any damages or losses whatsoever.

13) **Limitation of Liability**

    1. You acknowledge and agree that all access and use of the App, or use of the Services are at your own risk. 
    2. WE AND OUR SUPPLIERS AND LICENSORS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL, OR EXEMPLARY DAMAGES, INCLUDING BUT NOT LIMITED TO: DAMAGES FOR LOSS OF PROFITS, GOODWILL, USE, DATA, OR OTHER INTANGIBLE LOSSES (EVEN IF WE HAVE BEEN ADVISED OF THE POSSIBILITY OF THESE DAMAGES), RESULTING FROM YOUR USE OF OUR APP, AND SOFTWARE. UNDER NO CIRCUMSTANCES WILL THE TOTAL LIABILITY OF US AND OUR SUPPLIERS AND LICENSORS OF ALL KINDS AND UNDER NO CIRCUMSTANCES WILL THE TOTAL LIABILITY OF YOU (CARESOURCE AND ITS USERS AND AGENTS) ARISING OUT OF OR RELATED TO YOUR USE OF THE APP, AND SOFTWARE (INCLUDING BUT NOT LIMITED TO WARRANTY CLAIMS), REGARDLESS OF THE FORUM AND REGARDLESS OF WHETHER ANY ACTION OR CLAIM IS BASED ON CONTRACT, TORT, OR OTHERWISE, EXCEED THE AMOUNTS, IF ANY, THAT YOU HAVE PAID FOR YOUR USE OF THE APP, AND SOFTWARE. 

14) **Indemnification**

    1. You agree to indemnify and hold Trait Tech and its subsidiaries, affiliates, officers, agents, licensors, employees, partners, licensors or others involved in creating, sponsoring, promoting or otherwise making available the App, Services and data, harmless from any and all claims, damages, losses or liabilities, including reasonable attorneys' fees and expenses, made by any third party due to or arising out of any action, inaction or omission by you. 

15) **Force Majeure**

    1. Trait Tech shall not be deemed to be in default of any provision hereof or be liable for any delay, failure in performance, or interruption of service resulting directly or indirectly from acts of God, civil, public, or military authority, civil disturbance, war, terrorism, strikes, fires, other catastrophes, power or telecommunications failure, embargoes, sanctions, government orders, or any other cause beyond its reasonable control. If the delay continues for a period more than six (6) months, either party shall be entitled to terminate these Terms on written notice. 

16) **Duration and Termination**

    1. These Terms will remain in full force and effect while you use the App and Services.
    2. We reserve the right to restrict your access, temporarily or indefinitely suspend Services and/or App if:

a) you breach these Terms or other policies;

b) we believe that your actions may cause any loss or liability to our Users or to us;

c) we believe, in our sole discretion, that your actions may cause legal liability for you, our Users, us, or our affiliates; may be contrary to the interests of the App or the user community; or may involve illicit activity. 

3. Any terms and conditions of these Terms that may survive termination shall survive termination, including, without limitation, ownership provisions, warranty disclaimers, indemnity, and limitations of liability.

17) **Governing Law; Dispute Resolution**

    1. These Terms shall be construed and governed by the laws of Singapore without prejudice to its conflict of laws.
    2. All disputes directly arising under these Terms, which cannot be settled amicably, shall be submitted to settlement proceedings under the Rules of Arbitration of the International Chamber of Commerce by one or more arbitrators appointed in accordance with said Rules. If the dispute has not been settled pursuant to the said Rules within ninety (90) days following the filing of a Request for ADR or within such other period as the Parties may agree in writing, such dispute shall be finally settled under the rules of arbitration of the International Chamber of Commerce by one or more arbitrators appointed in accordance with the said rules of arbitration. The place of arbitration shall be Singapore. The chairman of such arbitration shall be of legal education. The arbitral proceedings shall be conducted in English. The award of the arbitration will be final and binding upon the Parties. 

18) **Miscellaneous**

    1. We reserve the right to modify, suspend or terminate any Services or products available through the App, at any time for any reason with or without notice to you. 
    2. If any portion of these Terms is found illegal or unenforceable, in whole or in part, such provision shall, as to such jurisdiction, be ineffective solely to the extent of such determination of invalidity or unenforceability without affecting the validity or enforceability thereof in any other manner or jurisdiction and without affecting the remaining provisions of the Terms, which shall continue to be in full force and effect.
    3. No joint venture, partnership, employment, or agency relationship exists between you and Trait Tech as a result of these Terms.
    4. No waiver by either party of any default by the other in the performance of any provisions of these Terms shall operate as a waiver of any continuing or future default, whether of a like or different character.
    5. Trait Tech reserves the right to assign its obligations and duties in these Terms to any person or entity.
    6. Any notice or other communication to be given to us under these Terms shall be in writing in the English language unless otherwise agreed between Trait Tech and the user. Any notice or other communication from users shall take effect only when received by us unless such notice or another communication is contrary to these Terms.
    7. These Terms constitute the entire agreement between you and Trait Tech with respect to your use of the App, purchase of Trait Token, use of the Products and Services. For issues related to any of the above, the User agrees to rely only on these Terms with respect to the subject matter hereof. 
    8. These Terms supersede any prior and contemporaneous agreements and understandings, whether written or oral, between the Parties with respect to the subject matter hereof. There are no representations, understandings or agreements relating to these Agreement that are not fully expressed in these Terms.

19) **Contact Us**

    1. If you have questions in relation to these Terms, please contact us at <support@trait.tech>. Trait Tech Pte. Ltd., Republic of Singapore.
    2. © Copyright 2023 Trait Tech Pte. Ltd. All Rights Reserved.

Last Updated: February 28, 2024
						""".toRichTextStr()
	)
}


@Preview(
	name = "light", group = "general", uiMode = Configuration.UI_MODE_NIGHT_NO,
	showBackground = true, backgroundColor = 0xFFFFFFFF,
)
@Preview(
	name = "dark", group = "general",
	uiMode = Configuration.UI_MODE_NIGHT_YES,
	showBackground = true, backgroundColor = 0xFF000000,
)
@Composable
private fun PreviewTAC() {
	SignerNewTheme {
		//doesn't work in dark mode? Check runtime, it's preview broken for this library
		TosScreen({})
	}
}
