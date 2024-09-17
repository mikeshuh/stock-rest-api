// src/pages/LegalPage.tsx
import React from 'react';

const LegalPage: React.FC = () => {
  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Legal Information</h1>
      <div className="bg-white p-6 rounded-lg shadow">
        <h2 className="text-2xl font-semibold mb-4">Terms of Service</h2>
        <p className="mb-4">
          By using Red Panda Trading, you agree to comply with and be bound by the following terms and conditions of use. 
          Please review the following terms carefully.
        </p>
        <ul className="list-disc list-inside mb-4">
          <li>You must be at least 18 years old to use this service.</li>
          <li>You are responsible for maintaining the confidentiality of your account and password.</li>
          <li>You agree to accept responsibility for all activities that occur under your account.</li>
          <li>We reserve the right to refuse service, terminate accounts, or remove content at our discretion.</li>
        </ul>
        
        <h2 className="text-2xl font-semibold mb-4 mt-8">Privacy Policy</h2>
        <p className="mb-4">
          Your privacy is important to us. It is Red Panda Trading's policy to respect your privacy regarding any information 
          we may collect from you across our website and other sites we own and operate.
        </p>
        <ul className="list-disc list-inside mb-4">
          <li>We only collect personal information when we truly need it to provide a service to you.</li>
          <li>We store your data securely and only retain collected information for as long as necessary.</li>
          <li>We don't share any personally identifying information publicly or with third-parties, except when required by law.</li>
        </ul>
        
        <h2 className="text-2xl font-semibold mb-4 mt-8">Disclaimer</h2>
        <p className="mb-4">
          The information provided by Red Panda Trading is for general informational purposes only. All information on the site 
          is provided in good faith, however, we make no representation or warranty of any kind, express or implied, regarding 
          the accuracy, adequacy, validity, reliability, availability, or completeness of any information on the site.
        </p>
        <p className="mb-4">
          Under no circumstance shall we have any liability to you for any loss or damage of any kind incurred as a result of 
          the use of the site or reliance on any information provided on the site. Your use of the site and your reliance on 
          any information on the site is solely at your own risk.
        </p>
      </div>
    </div>
  );
};

export default LegalPage;