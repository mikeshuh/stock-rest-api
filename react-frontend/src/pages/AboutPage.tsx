// src/pages/AboutPage.tsx
import React from 'react';

const AboutPage: React.FC = () => {
  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">About Red Panda Trading</h1>
      <div className="bg-white p-6 rounded-lg shadow">
        <h2 className="text-2xl font-semibold mb-4">Our Mission</h2>
        <p className="mb-4">
          At Red Panda Trading, our mission is to democratize stock trading and make it accessible to everyone. 
          We believe that with the right tools and knowledge, anyone can become a successful investor.
        </p>
        <h2 className="text-2xl font-semibold mb-4">What We Offer</h2>
        <ul className="list-disc list-inside mb-4">
          <li>Real-time stock data and analysis</li>
          <li>User-friendly trading interface</li>
          <li>Educational resources for beginners and advanced traders</li>
          <li>Personalized portfolio management tools</li>
        </ul>
        <h2 className="text-2xl font-semibold mb-4">Our Team</h2>
        <p className="mb-4">
          Red Panda Trading was founded by a team of finance experts and tech enthusiasts who saw the need for a 
          more accessible and user-friendly trading platform. Our diverse team brings together expertise from 
          Wall Street, Silicon Valley, and everything in between.
        </p>
        <h2 className="text-2xl font-semibold mb-4">Contact Us</h2>
        <p>
          Have questions or feedback? We'd love to hear from you!<br />
          Email: support@redpandatrading.com<br />
          Phone: (123) 456-7890
        </p>
      </div>
    </div>
  );
};

export default AboutPage;