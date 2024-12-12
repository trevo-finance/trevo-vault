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
 * Privacy policy content
 */

@Composable
fun PpScreen(onBack: Callback) {
	Column(
		Modifier
			.verticalScroll(rememberScrollState())
	) {
		ScreenHeader(
			title = stringResource(R.string.documents_terms_of_service),
			onBack = onBack
		)
		PpText(modifier = Modifier.padding(16.dp))
	}

	BackHandler(onBack = onBack)
}

@Composable
fun PpText(modifier: Modifier = Modifier) {
	MarkdownText(
		modifier = modifier,
		content =
		"""
**Privacy Policy** 

Last updated: 3 November 2023 

TRAIT TECH PTE. LTD. (“**Trait Tech**”, “**we**”, “**our**”, “**us**”) receives, collects, stores, and manages user personal data according to the following Privacy Policy. We take pride in treating our users’ privacy the way we would like to be treated ourselves. We make sure we comply with the applicable personal data protection laws and regulations. 

By visiting our website https\://trait.tech/ (“**Website**”), and/or sharing any personal information as described below, and/or using any of Trait Tech’s products and services (the “**Services**”), you agree to the terms of this Privacy Policy. 

**1. Data Collected** 

1.1 **Data that you voluntarily provide us with:** 

1.1.1 You may provide us with your personal data in a number of ways, including, without limitation, when you sign up for and use the Services; have previously provided us with personal information prior to this Privacy Policy or last updates coming into effect; make any payment for the Services; subscribe to any alerts, information releases, news, newsletters, updates and media releases; complete and submit any forms to us; post any content on or through the Website; contact us directly in person or via any medium including but not limited to by mail, telephone, social media and commercial electronic messages; communicate with us for any matters and interact with or browse the Website generally. 

1.1.2 Personal data that may be provided by you includes, but is not limited to: 1) contact information such as your full name, current and valid email address; 2) personal data for KYC and KYB checks; 

3\) account password; 

4\) physical address; 

5\) phone number; 

6\) billing information and purchase history; 

7\) more detailed contact preferences; 

8\) location data. 

1.1.3 By giving us this data, you consent to this data being stored by us, as described in our Terms and this Privacy Policy. 

1.2 **Data that we collect automatically** 

1.2.1 We collect data from every visitor and customer of the Website, in particular we automatically collect data about your visit to the Website, your usage of the Services and your app and website browsing activities. This anonymized information may include IP address, browser type, browser language, cookies data, performance specifications of the user’s hardware and software, date and time of access to the Website and the URL of the page requested, other information about how you interacted with our Website and our Services.

**1.3 Data from your use of the Services** 

1.3.1 We may receive data about how and when you use the Services, store it in log files or other types of files associated with your account, and link it to other information we collect about you. This data may include, for example, your IP address, time, date, browser used, and actions you have taken within the Website. This type of data helps us to improve our Services for both you and for all of our users. 

**1.4 Cookies and tracking** 

1.4.1 Cookies are small data files that are placed on your computer or mobile device when you visit a website. Website owners use cookies to make their websites operate, improve functionality and user experience, as well as to provide reporting information. 

1.4.2 We may set our own cookies and use third parties cookies (e.g. for advertising, interactive content and analytics). 

1.4.3 We use different types of cookies, including: 

1\) **Essential website cookies**: these are important cookies as they are necessary to provide you with services available through our Website, such 

as access to secure areas. 

2\) **Performance and functionality cookies**: these cookies are necessary to enhance the performance and functionality of our Website but are 

non-essential to their use. However, without these cookies, certain 

functionality may become unavailable. 

3\) **Analytics and customization cookies**: these cookies collect information that is used either in aggregate form to help us understand how our 

Website is being used or how effective our marketing campaigns are, or to 

help us customize our Website for you in order to enhance your 

experience. 

4\) **Advertising cookies**: these cookies are used to make advertising messages more relevant to you. They perform functions like preventing the same ad 

from continuously reappearing, ensuring that ads are properly displayed, 

and in some cases selecting advertisements that are based on your 

interests. 

5\) **Stripe\_mid and Stripe\_sid**: these are cookies that enable the process of card transactions on the Website. The transaction is made by Stripe 

without storing any credit card information. 

1.4.4 You may opt out from cookies at any time by customizing your cookie preferences. However, in some cases we will not be able to provide you with all services. 

**1.5 Web beacons and similar technologies** 

1.5.1 Apart from cookies, we use other similar technologies, like web beacons, to monitor traffic, deliver and communicate with cookies, improve site performance. Similar to cookies you may opt out from web beacons at any time. If you wish to opt out of this processing activity, please contact us at token\@trait.tech with the subject named “Privacy Policy”. 

**1.6 Data from third party sources**

1.6.1 We may receive some information about you, such as name, email address, demographic information, IP address, location, and use of social media websites, from third parties. 

**1.7 Opting-Out** 

1.7.1 You may decline to have your personal data collected via third party tracking technologies by navigating to the settings feature in your browser and declining all third party cookies or declining third party cookies from specific sites, or, for mobile, limiting ad tracking or resetting the advertising identifier via the privacy settings on your mobile device. 

1.7.2 If your browser does not permit you to block any cookies and similar technologies, you can use the following third party tools to decline the collection and use of information for the purpose of serving your interest based advertising: 

- The NAI’s opt-out platform: http\://www\.networkadvertising.org/choices/ 
- The EDAA’s opt-out platform http\://www\.youronlinechoices.com/ 
- The DAA’s opt-out platform: http\://optout.aboutads.info/?c=2\&lang=EN 

**2. Minors** 

2.1. Minors and children under the age of 16 (or other legal age of your country of residence) should not use our Services. If you are 13 years of age up to 16, you need to obtain a written parental or guardian consent, unless the law of the country of your residence prescribes higher age requirements, in which case you need to meet such requirements. We do not knowingly provide any Services to minors. If you access our Services, you represent that you have the legal capacity to enter into a binding agreement. 

**3. Use of the Data** 

3.1. We only use your personal data for the following purposes: 

3.1.1 to provide you with the Services that you requested; 

3.1.2 to promote the use of our Services to you; 

3.1.3 to analyze and improve Trait Tech Services; 

3.1.4 to send you informational and promotional content that you may subscribe to or unsubscribe; 

3.1.5 to bill and collect money for Services ordered; 

3.1.6 to send you notifications, including notifications on change of our Services; 

3.1.7 to communicate with our customers about our Website and Services and provide customer support in response to their inquiries; 

3.1.8 to enforce compliance with our Terms and applicable law; 

3.1.9 to protect our rights and safety as well as the rights and safety of our customers and third parties; 

3.1.10 to meet legal requirements; 

3.1.11 to provide information to representatives and Service Providers; 

3.1.12 to prosecute and defend a court, arbitration, or similar legal proceeding;

3.1.13 to respond to lawful requests by public authorities, including to meet national security or law enforcement requirements; 

3.1.14 to provide, support, and improve the Services we offer; 

3.1.15 to provide suggestions about products or services that you may be interested in and which you may opt out; 

3.1.16 to transfer your information in the case of a sale, merger, consolidation, liquidation, reorganization, or acquisition. 

**4. Sharing of Data** 

4.1 We do not share personal information you have provided to us without your consent, unless: 4.1.1 Doing so is appropriate to carry out your own request; 

4.1.2 We believe it is needed to enforce our Terms, or if it is legally required; 

4.1.3 We believe it is needed to detect, prevent or address fraud, security or technical issues; 

4.1.4 Otherwise protect our property, legal rights, or that of others. 

4.2 Trait Tech is operated from the Republic of Singapore. If you are visiting the Website or Services from outside of Singapore, you agree to any processing of any personal information you provide us according to this policy. 

4.3 We don't share your personal information with third parties, except for people and other entities that perform certain tasks on our behalf and who are under our control (our “Service Providers”). We may need to share personal information with our Service Providers in order to provide products or services to you. Unless we tell you differently, our Service Providers do not have any right to use Personal Information or other information we share with them beyond what is necessary to assist us. You hereby consent to our sharing of personal information with our Service Providers. Our Service Providers are:

|        |                              |                                 |                                                |
| :----: | :--------------------------: | ------------------------------- | ---------------------------------------------- |
| **#**  |       **Entity Name**        | **Webpage**                     | **Purpose**                                    |
|   1.   |          Google LLC          | https\://analytics.google.com/  | We use Google Analytics for analytical purpose |
|   2.   |        Amplitude Inc.        | https\://amplitude.com          | For analytical purpose                         |
|   3.   |         Stripe, Inc.         | https\://stripe.com/            | For payment processing                         |
|   4.   | Wise / Wise Payments Limited | https\://wise.com               | For payment processing                         |

****

|     |                                |                       |                                               |
| :-: | ------------------------------ | --------------------- | --------------------------------------------- |
| 5.  | Sumsub / Sum and Substance Ltd | https\://sumsub.com/  | For customer verification to comply with laws |
| 6.  | Onfido Ltd                     | https\://onfido.com   | For customer verification to comply with laws |

****

4.4 Only aggregated, anonymized data is periodically transmitted to external services to help us improve the Website and Services. To receive the current list of external services that we use for this purpose, please email at token\@trait.tech. 

**5. Safeguarding your Personal Data** 

5.1 The protection of your personal data is vital to us. We take commercially reasonable measures to protect your personal data from loss, misuse and unauthorized access, disclosure, alteration, and destruction, considering the risks involved in the processing and the nature of the personal data, thanks to the use of the following technologies: 

⎯ SSL certificates, 

⎯ Two-factor authentication. 

5.2 Our employees, contractors and any business partners can access personal data on a need-to-know basis, and under a strict duty of maintaining confidentiality. We use encryption for sensitive information, and we test our system on a regular basis to ensure we comply with industry practices and standards. 

5.3 While we strive to use commercially acceptable means to protect your personal data, no method of transmission over the Internet, or method of electronic storage, is completely secure, and we cannot guarantee the absolute security of any data. 

5.4 You agree to protect the security of your login information and password and not to transfer such information to any third party. We will not be liable to you for the use of your account by any third party. 

5.5 If you become aware of any unauthorized use of your account, you shall immediately notify us in writing. 

**6. Access to your Personal Data** 

6.1 You may access your personal data held by us to correct, update, and remove inaccurate or incorrect data. You have the following rights: 

6.1.1 delete some or all personal data that we held about you; 

6.1.2 change or correct your personal data that we held about you; 

6.1.3 object to, or limit or restrict, use of your personal data; 

6.1.4 right to access and/or take your personal data: you can ask us for a copy of your personal information in machine readable form; 

6.1.5 access information we hold about you.

6.2 If you request us to view, change and remove your data associated with your account, please contact us at token\@trait.tech. We will process your request within 15 business days. In accordance with the applicable laws, additional fees may be applied. 

**7. Changes to the Privacy Policy** 

7.1 We may amend this Privacy Policy from time to time. Use of information we collect now is subject to the Privacy Policy in effect at the time such information is used. If we make major changes in the way we collect or use information, we will notify you by posting an announcement on the Website or sending you an email. 

**8. Merge of Company** 

8.1 If Trait Tech merges with, or is acquired by, another company or organization, or sells all or a portion of its assets, your personal data may be disclosed to our advisers and any prospective purchaser or any prospective purchaser’s adviser and may be among the assets transferred. However, personal data will always remain subject to this Privacy Policy. 

**9. Data Retention** 

9.1 We retain your personal data primarily within the Republic of Singapore. We retain your personal data for as long as we need it to fulfil the purposes for which we originally collected it or as needed to provide with the Services, except if required otherwise by law. In some cases we may determine the period of data retention based on the period we need to access the data for the provision of services, receiving payment, or for any other auditing or legal purposes. 

9.2 Countries where we process information may have laws that are different, and potentially not as protective, as the laws of your own country, though we will always comply with the applicable laws when we process any information. 

**10. Contact us** 

10.1 Should you have any questions or concerns, please email us at support\@trait.tech.
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
private fun PreviewPp() {
	SignerNewTheme {
		//doesn't work in dark mode? Check runtime, it's preview broken for this library
		PpScreen({})
	}
}
