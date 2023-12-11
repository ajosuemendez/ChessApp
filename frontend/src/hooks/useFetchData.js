// useFetchData.js
import { useState, useEffect } from 'react';

const useFetchData = (apiEndpoint, params) => {
  const [data, setData] = useState();
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);

      try {
        const response = await fetch(`${apiEndpoint}${params}`);
        if (!response.ok) {
          throw new Error('Failed to fetch data');
        }

        const result = await response.json();
        setData(result);
      } catch (error) {
        setError(error.message);
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();
  }, [apiEndpoint, params]);

  return { data, isLoading, error };
};

export default useFetchData;
