import React from 'react';
import './testTemplate.css';

const TestTemplate = ({form, children}) =>{
    return (
        <main className="testTemplate">
            <div className="title">
                News Flow
            </div>
            <section className="form-wrapper">
                {form}
            </section>
            <section className="test-wrapper">
                {children}
            </section>
        </main>
    );
};
export default TestTemplate;